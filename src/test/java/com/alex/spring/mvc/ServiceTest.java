package com.alex.spring.mvc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.mvc.service.ContactService;

public class ServiceTest {

	private GenericXmlApplicationContext ctxt;
	private ContactService service;
	
	
	public void initContext(){
		ctxt = new GenericXmlApplicationContext();
		ctxt.load("root-context.xml");
		ctxt.refresh();
		
		service = ctxt.getBean("contactService", ContactService.class);
	}
	
	@Test(expected = NullPointerException.class)
	@Ignore
	public void test() {
		service.findAllContacts();
	}

}
