package com.alex.spring.mvc.service;

import java.util.List;

import com.alex.spring.mvc.domain.Contact;

public interface ContactService {

	public List<Contact> findAllContacts();
	
	public List<Contact> findByFirstName(String firstName);

	public Contact findById(Long id);

	public Contact save(Contact contact);

	public void delete(Contact contact);
}
