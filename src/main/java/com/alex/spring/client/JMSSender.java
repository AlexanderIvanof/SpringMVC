package com.alex.spring.client;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.alex.spring.jms.sender.MessageSender;

public class JMSSender {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:jms/jms-context-sender.xml");
		context.refresh();
		
		MessageSender sender = context.getBean("messageSender", MessageSender.class);
		
		sender.sendMassage("Hello from Spring to Spring!");
	}

}
