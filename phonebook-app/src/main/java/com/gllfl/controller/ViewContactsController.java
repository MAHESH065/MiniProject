package com.gllfl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.gllfl.AppConstant;
import com.gllfl.entity.Contact;
import com.gllfl.service.ContactService;

@Controller
public class ViewContactsController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/update")
	public String updateContact(@RequestParam("id") Integer contactId, Model model) {
		
		Contact contactObj = contactService.getContactById(contactId);
		model.addAttribute(AppConstant.CONTACT, contactObj);
		return AppConstant.CONTACT_FORM;
				 
	}
	
	@GetMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable(name = "contactId") Integer contactId) {
		
		Contact contactObj = contactService.getContactById(contactId);
		if(contactObj != null) {
			contactService.deleteContactById(contactId);
			return "redirect:/viewContact";
		}else {
			return AppConstant.NO_RECORD;
		}
	}
	
}
