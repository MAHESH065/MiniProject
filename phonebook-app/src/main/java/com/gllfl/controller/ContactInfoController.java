package com.gllfl.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gllfl.entity.Contact;
import com.gllfl.props.AppProps;
import com.gllfl.service.ContactService;

@Controller
public class ContactInfoController {
	
	@Autowired
	private AppProps props;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact")
	public String loadContactForm(Model model) {
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		return "contactForm-page";
	}
	
	@PostMapping("/saveContact")
	public String insertContact(Contact contact, Model model) {
		
		boolean contactObj = contactService.saveContact(contact);
		
		Map<String, String> messages = props.getMessages();
		
		if (contactObj ) {
			model.addAttribute("success", messages.get("saveSuccessMessage"));
		}else {
			model.addAttribute("fail", "saveFailMessage");
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
