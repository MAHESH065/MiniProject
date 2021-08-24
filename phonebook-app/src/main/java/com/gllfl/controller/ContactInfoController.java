package com.gllfl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gllfl.entity.Contact;
import com.gllfl.service.ContactService;

@Controller
public class ContactInfoController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact")
	public String loadContactForm(Model model) {
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		return "contactInfo";
	}
	
	@PostMapping("/saveContact")
	public String insertContact(Contact contact, Model model) {
		boolean contactObj = contactService.saveContact(contact);
		if (contactObj) {
			model.addAttribute("success", "Contact Data saved successfully...");
		}else {
			model.addAttribute("error", "Failed to save Contact Data.. Please Try Again!!");
		}
		return "contactInfo";
	}
}
