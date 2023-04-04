package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Adminproduct;
import com.example.demo.service.AdminproductService;

@Controller


public class AdminproductController {
	
	@Autowired
	private AdminproductService adminproductService;
	@GetMapping("/admin_product")
	public String viewAdminProductPage(Model model)
	{
	model.addAttribute("listproducts", adminproductService.getAllProducts());
	return "admin_product";
	}
	@GetMapping("/showNewProductForm")
	public String showNewProductForm(Model model)
	{
		Adminproduct adminproduct = new Adminproduct();
		model.addAttribute("adminproduct", adminproduct);
		return "new_product";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("adminproduct")Adminproduct adminproduct)
	{
		adminproductService.saveProduct(adminproduct);
		return "redirect:/admin_product";
	}
	
	@GetMapping("/showFormForUpdateProduct/{id}")
	public String showFormForUpdateProduct(@PathVariable (value = "id") long id,Model model ) {
		Adminproduct adminproduct=adminproductService.getAdminproductById(id);
		model.addAttribute("adminproduct",adminproduct);
		return "Update_product";
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteEmployee(@PathVariable (value="id") long id) {
		
		this.adminproductService.deleteEmployeebyId(id);
		return "redirect:/admin_product";
	}
	
	
	
	
	

}
