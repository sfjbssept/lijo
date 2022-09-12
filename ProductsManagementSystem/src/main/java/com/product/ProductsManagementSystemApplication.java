package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ProductsManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsManagementSystemApplication.class, args);
	}

}
