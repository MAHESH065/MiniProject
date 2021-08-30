package com.gllfl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gllfl.entity.Contact;
import com.gllfl.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSwitch('Y');
		Contact contactObj = contactRepo.save(contact);
		if(contactObj != null && contactObj.getContactId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactList = contactRepo.findAll();
		return contactList;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> contactObjById = contactRepo.findById(contactId);
		if(contactObjById.isPresent()) {
			Contact contact = contactObjById.get();
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		boolean status = contactRepo.existsById(contactId);
		if(status) {
			contactRepo.deleteById(contactId);
			return true;
		}
		return false;
	}
	
}
