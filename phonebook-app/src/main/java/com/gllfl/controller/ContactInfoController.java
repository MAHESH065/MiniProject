package com.gllfl.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gllfl.AppConstant;
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
		model.addAttribute(AppConstant.CONTACT, contactObj);
		return AppConstant.CONTACT_FORM;
	}
	
	@PostMapping("/saveContact")
	public String insertContact(Contact contact, Model model) {
		
		boolean contactObj = contactService.saveContact(contact);
		
		Map<String, String> messages = props.getMessages();
		
		if (contactObj ) {
			model.addAttribute(AppConstant.SUCCESS, messages.get(AppConstant.SUCCESS_MESSAGE));
		}else {
			model.addAttribute(AppConstant.Fail, AppConstant.FAIL_MESSAGE);
		}
		return AppConstant.CONTACT_FORM;
	}
	
	@GetMapping("/viewContact")
	public String viewContactList(Model model) {
		List<Contact> contactList = contactService.getAllContacts();
		model.addAttribute(AppConstant.CONTACT, contactList);
		return AppConstant.VIEW_CONTACTS;
	}
		
}
