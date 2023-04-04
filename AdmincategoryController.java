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

import com.example.demo.model.Admincategory;
import com.example.demo.model.Adminproduct;
import com.example.demo.service.AdmincategoryService;

@Controller

public class AdmincategoryController{
	
	@Autowired
	private AdmincategoryService admincategoryService;
	
	@GetMapping("/admin_category")
	public String viewCategoryPage(Model model)
	{
	model.addAttribute("listCategories", admincategoryService.getAllCategories());
	return "admin_category";
	}
	
	@GetMapping("/showNewCategoryForm")
	public String showNewCategoryForm(Model model) {
		Admincategory admincategory=new Admincategory();
		model.addAttribute("admincategory", admincategory);
		return "new_category";
	}
	
	
	@PostMapping("/saveCategory")
	public String saveProduct(@ModelAttribute("adminproduct")Admincategory admincategory)
	{
		admincategoryService.saveCategory(admincategory);
		return "redirect:/admin_category";
	}
	
	@GetMapping("/showFormForCategoryUpdate/{id}")
	public String showFormForCategoryUpdate(@PathVariable (value = "id") long id,Model model ) {
		Admincategory admincategory=admincategoryService.getAdmincategoryById(id);
		model.addAttribute("admincategory",admincategory);
		return "Update_category";

	}
	
	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable (value="id") long id) {
		
		this.admincategoryService.deleteCategorybyId(id);
		return "redirect:/admin_category";
	}
}
