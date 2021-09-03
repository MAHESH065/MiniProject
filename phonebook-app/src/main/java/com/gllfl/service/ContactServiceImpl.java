package com.gllfl.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gllfl.AppConstant;
import com.gllfl.entity.Contact;
import com.gllfl.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSwitch(AppConstant.YES);
		Contact contactObj = contactRepository.save(contact);
		return (contactObj != null && contactObj.getContactId() != null);		
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactList = contactRepository.findAll();
		
		return contactList.stream().filter(contact -> contact.getActiveSwitch() == AppConstant.YES).collect(Collectors.toList());
		
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> contactObjById = contactRepository.findById(contactId);
		if(contactObjById.isPresent()) {
			return contactObjById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		
		Optional<Contact> optionalObj = contactRepository.findById(contactId);
		
		if(optionalObj.isPresent()) {
			Contact contact = optionalObj.get();
			contact.setActiveSwitch(AppConstant.NO);
			contactRepository.save(contact);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
}
