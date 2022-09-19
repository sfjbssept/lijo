package com.stud.service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stud.service.entity.Student;

@RestController
@RequestMapping("/getstudent")
public class StudentController {
	
	private static Map<String,List<Student>>  schoolDB= new HashMap<String,List<Student>>();
	
	static {
		 schoolDB= new HashMap<String,List<Student>>();
		 List<Student> studentList = new ArrayList<Student>();
		 studentList.add(new Student("Raju","JNV"));
		 studentList.add(new Student("Riyansh","Kit"));
		 studentList.add(new Student("Ayandh","Nagaji"));
		 studentList.add(new Student("Saroj","Govent School"));
		 
		 schoolDB.put("School1", studentList);
		 schoolDB.put("School2", studentList);
		 
		
	}
	
	 @GetMapping("/school/{schoolname}") 
	 List<Student> getStudent(@PathVariable String schoolname){
		 List<Student> stulist= schoolDB.get(schoolname);
		if(stulist== null) {
			stulist = new ArrayList<Student>() ;
			Student student = new Student("Not found", "Not found");
			stulist.add(student);
		}
		 return stulist;
	 }
	 

}
