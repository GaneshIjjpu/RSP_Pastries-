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

import com.example.demo.model.Adminevent;
import com.example.demo.service.AdmineventService;

@Controller

public class AdmineventController{
	
	@Autowired
	private AdmineventService admineventService;
	
	@GetMapping("/admin_event")
	public String viewEventPage(Model model)
	{
	model.addAttribute("listEvents", admineventService.getAllEvents());
	return "admin_event";
	}
	
	@GetMapping("/showNewEventForm")
	public String showNewEventForm(Model model) {
		Adminevent adminevent=new Adminevent();
		model.addAttribute("adminevent", adminevent);
		return "new_event";
	}
	
	
	@PostMapping("/saveEvent")
	public String saveEvent(@ModelAttribute("adminevent")Adminevent adminevent)
	{
		admineventService.saveEvents(adminevent);
		return "redirect:/admin_event";
	}
	
	@GetMapping("/showFormForEventUpdate/{id}")
	public String showFormForEventUpdate(@PathVariable (value = "id") long id,Model model ) {
		Adminevent adminevent=admineventService.getAdmineventById(id);
		model.addAttribute("adminevent",adminevent);
		return "Update_event";

	}
	
	@GetMapping("/deleteEvent/{id}")
	public String deleteEvent(@PathVariable (value="id") long id) {
		
		this.admineventService.deleteEventbyId(id);
		return "redirect:/admin_event";
	}
}
