package com.gllfl.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gllfl.entity.Contact;
import com.gllfl.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSwitch('Y');
		Contact contactObj = contactRepository.save(contact);
		if(contactObj != null && contactObj.getContactId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactList = contactRepository.findAll();
		
		List<Contact> filterContactList = contactList.stream().filter(contact -> contact.getActiveSwitch() == 'Y').collect(Collectors.toList());
		return filterContactList;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> contactObjById = contactRepository.findById(contactId);
		if(contactObjById.isPresent()) {
			Contact contact = contactObjById.get();
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		
		Optional<Contact> optionalObj = contactRepository.findById(contactId);
		
		if(optionalObj.isPresent()) {
			Contact contact = optionalObj.get();
			contact.setActiveSwitch('N');
			contactRepository.save(contact);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
}
