package com.rabbit.app.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbit.app.config.MessagingConfig;
import com.rabbit.app.entity.EmployeeStatus;

@Component
public class Consumer {

	@RabbitListener(queues = MessagingConfig.QUEUENAME)
	public void consumerMessageFromQueue(EmployeeStatus status) {
		System.out.print(status+"Message Recieved");
	}
}
