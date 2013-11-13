package com.alex.spring.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alex.spring.mvc.domain.Contact;
import com.alex.spring.mvc.service.ContactService;

@Controller
public class ContactController {

	final Logger logg = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService service;
	
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String list(Model uiModel){
		logg.info("Try to get list of contacts");
		
		List<Contact> contacts = service.findAllContacts();
		uiModel.addAttribute("contacts", contacts);
		logg.info("Size of contacts is " + contacts.size());
		
		return "contacts/list";
	}
	
	@RequestMapping("*")
	public String index(){
		return "index";
	}
}
