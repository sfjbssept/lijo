package com.rabbit.app.producer;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.app.config.MessagingConfig;
import com.rabbit.app.consumer.Consumer;
import com.rabbit.app.entity.Employee;
import com.rabbit.app.entity.EmployeeStatus;

@RestController
@RequestMapping("/Employee")
public class EmployeePublisher {

	@Autowired
	private RabbitTemplate template;
	
	
	
	@PostMapping("/{companyname}")
	public String saveEmployee(@RequestBody Employee employee,@PathVariable String companyname) {
		employee.setEmpId(UUID.randomUUID().toString());
		EmployeeStatus employeeStatus = new EmployeeStatus(employee,"test");
		template.convertAndSend(MessagingConfig.EXCHANGENAME,MessagingConfig.ROUTING_KEY,employeeStatus);
		
		return "success";
	}
}
