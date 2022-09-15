package com.student.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Student")
public class Student {

	private Integer id;
	private String name;
	private String college;
	private String city;
}
