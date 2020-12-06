package com.mycompany.persistence;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.model.Contact;

public class ContactDao {
	
	//in-memory storage of contacts
	//assume the concatenation of first name and last name is the primary key to look up the contact
	//assume each person can have only one contact
	private static Map<String, Contact> mapContacts;
	
	static {
		if (mapContacts==null) {
			mapContacts = new HashMap<String,Contact>();
		}
	}
	
	//Create a new contact
	public void createContact(Contact contact) {
		ContactDao.mapContacts.put(contact.getFirstName()+contact.getLastName(),contact);
	}
	
	//get contact
	//return a blank contact if not found
	public Contact getContact(String firstName, String lastName) {
		Contact contact = ContactDao.mapContacts.get(firstName+lastName);
		if (contact== null) contact = new Contact();
		return contact;
		
	}
	
	//Update contact
	//if not found, add one
	public void updateContact(Contact newContact) {
		String key = newContact.getFirstName()+newContact.getLastName();
		Contact contact = mapContacts.get(key);
		if (contact!=null) {
			contact.setEmailAddress(newContact.getEmailAddress());
		}else {
			mapContacts.put(key, newContact);
		}
	}
	
	//Delete a contact
	public void deleteContact(String firstName, String lastName) {
		mapContacts.remove(firstName+lastName);
	}
	
	
}
