package com.example.demo.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class MainController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}
	
	@GetMapping("/user")
	public String page() {
		return "User";
	}
	@GetMapping("/signup")
	public String signpage() {
		return "Signup";
	}
		
	}
	