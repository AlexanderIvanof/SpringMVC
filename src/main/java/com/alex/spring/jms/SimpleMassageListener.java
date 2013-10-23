package com.alex.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleMassageListener implements MessageListener {

	private static Logger logger = LoggerFactory.getLogger(SimpleMassageListener.class);
	
	@Override
	public void onMessage(Message message) {
		try {
			TextMessage text = (TextMessage) message;
			logger.info("Message received: " + text.getText());
		} catch (JMSException e) {
			logger.error("JMS Error", e);
		}
	}

}
