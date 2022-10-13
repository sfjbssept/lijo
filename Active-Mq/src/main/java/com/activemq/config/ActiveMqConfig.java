package com.activemq.config;


import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;



@Configuration
public class ActiveMqConfig {

	@Value("${activemq.broker.url}")
	private String brokeUrl;
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sstandalone.queue");
		
	}
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokeUrl);
		//factory.setUserName("admin");
		//factory.setPassword("admin");
		return factory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(activeMQConnectionFactory());
	}
}
