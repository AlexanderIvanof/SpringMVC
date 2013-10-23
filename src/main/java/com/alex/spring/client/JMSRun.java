package com.alex.spring.client;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JMSRun {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:jms/jms-context.xml");
		context.refresh();
		
		while(true){
			
		}
	}

}
