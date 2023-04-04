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

import com.example.demo.model.Admincoupon;
import com.example.demo.service.AdmincouponService;

@Controller

public class AdmincouponController{
	
	@Autowired
	private AdmincouponService admincouponService;
	
	@GetMapping("/admin_coupon")
	public String viewEventPage(Model model)
	{
	model.addAttribute("listCoupons", admincouponService.getAllCoupons());
	return "admin_coupon";
	}
	
	@GetMapping("/showNewCouponForm")
	public String showNewCouponForm(Model model) {
		Admincoupon admincoupon=new Admincoupon();
		model.addAttribute("admincoupon", admincoupon);
		return "new_coupon";
	}
	
	
	@PostMapping("/saveCoupon")
	public String saveCoupon(@ModelAttribute("admincoupon")Admincoupon admincoupon)
	{
		admincouponService.saveCoupons(admincoupon);
		return "redirect:/admin_coupon";
	}
	
	@GetMapping("/showFormForCouponUpdate/{id}")
	public String showFormForCouponUpdate(@PathVariable (value = "id") long id,Model model ) {
		Admincoupon admincoupon=admincouponService.getAdmincouponById(id);
		model.addAttribute("admincoupon",admincoupon);
		return "Update_coupon";

	}
	
	@GetMapping("/deleteCoupon/{id}")
	public String deleteCoupon(@PathVariable (value="id") long id) {
		
		this.admincouponService.deleteCouponbyId(id);
		return "redirect:/admin_coupon";
	}
}
