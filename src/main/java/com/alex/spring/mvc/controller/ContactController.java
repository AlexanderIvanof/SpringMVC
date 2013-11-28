package com.alex.spring.mvc.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alex.spring.mvc.domain.Contact;
import com.alex.spring.mvc.service.ContactService;
import com.alex.spring.mvc.web.form.Message;

@Controller
public class ContactController {

	final Logger logg = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService service;
	@Autowired
	private MessageSource messSource;
	
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String list(Model uiModel){
		logg.info("Try to get list of contacts");
		
		List<Contact> contacts = service.findAllContacts();
		uiModel.addAttribute("contacts", contacts);
		logg.info("Size of contacts is " + contacts.size());
		
		return "contacts/list";
	}
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
	public String getByID(Model uiModel, @PathVariable("id") Long id){
		logg.info("Try to find contact");
		Contact contact = service.findById(id);
		uiModel.addAttribute("contact", contact);
		uiModel.addAttribute("cont_id", id);
		return "contacts/show";
	}
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.POST, params = "form")
	public String update(Contact contact, BindingResult result, Model uiModel,
			HttpServletRequest request, RedirectAttributes redAtt, Locale locale, @PathVariable("id")Long id)
	{
		logg.info("Updating contact...");
		System.out.println(">>>>>>>>>>>\n" + contact);
		if(result.hasErrors()){
			uiModel.addAttribute("message", new Message("error", messSource.getMessage("contact_save_fail", new Object[]{}, locale)));
			uiModel.addAttribute("contact", contact);
			return "contacts/update";
		}
		
		uiModel.asMap().clear();
		redAtt.addFlashAttribute("message", new Message("success", 
				messSource.getMessage("contact_save_success", new Object[]{}, locale)));
		service.save(contact);
		return "redirect:/contact/" + id;
	}
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET, params = "form")
	public String updateForm(Model uiModel, @PathVariable("id") Long id){
		uiModel.addAttribute("contact", service.findById(id));
		return "contacts/update";
	}
	
	@RequestMapping("*")
	public String index(){
		return "index";
	}
}
