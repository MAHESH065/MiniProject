package com.gllfl.controller;


import java.util.List;

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
		System.out.println("Load Form execute..");
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		return "contactForm-page";
	}
	
	@PostMapping("/saveContact")
	public String insertContact(Contact contact, Model model) {
		System.out.println("insertContact method execute..");
		boolean contactObj = contactService.saveContact(contact);
		
		if (contactObj ) {
			model.addAttribute("success", "Contact Data saved successfully...");
		}else {
			model.addAttribute("error", "Failed to save Contact Data.. Please Try Again!!");
		}
		return "contactForm-page";
	}
	
	@GetMapping("/viewContact")
	public String viewContactList(Model model) {
		List<Contact> contactList = contactService.getAllContacts();
		model.addAttribute("contact", contactList);
		return "viewContacts-page";
	}
		
}
