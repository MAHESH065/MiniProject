package com.gllfl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.gllfl.entity.Contact;
import com.gllfl.service.ContactService;

@Controller
public class ViewContactsController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/update")
	public String updateContact(@RequestParam("id") Integer contactId, Model model) {
		
		Contact contactObj = contactService.getContactById(contactId);
		model.addAttribute("contact", contactObj);
		return "contactInfo";
				 
	}
	
	@GetMapping("/delete/{contactId}")
	public String removeContact(@PathVariable("contactId") Integer ContactId) {
		
		/*
		 * boolean deleteContact= contactService.deleteContactById(ContactId);
		 * if(deleteContact) { return "redirect:/viewContact"; } return
		 * "data not found!!!!!";
		 */
		
		Contact contactObj = contactService.getContactById(ContactId);
		if(contactObj != null) {
			contactService.deleteContactById(ContactId);
			return "redirect:/viewContact";
		}else {
			return "No record exist for given id !!!!!";
		}
	}
	
}
