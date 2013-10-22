package com.alex.spring.mvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alex.spring.mvc.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	public List<Contact> findByFirstName(String firstNmae);
}
