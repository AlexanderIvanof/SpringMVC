package com.alex.spring.mvc.jpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alex.spring.mvc.domain.Contact;
import com.alex.spring.mvc.repository.ContactRepository;
import com.alex.spring.mvc.service.ContactService;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public List<Contact> findByFirstName(String firstName) {
		return contactRepository.findByFirstName(firstName);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Contact> findAllContacts() {
		List<Contact> result = new ArrayList<>();
		Iterable<Contact> conts = contactRepository.findAll();
		for(Contact cnt: conts){
			result.add(cnt);
		}
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Contact findById(Long id) {
		return contactRepository.findOne(id);
	}

	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public void delete(Contact contact) {
		contactRepository.delete(contact);
	}

}
