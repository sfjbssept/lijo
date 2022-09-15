package com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.IStudentService;

@RestController
public class StudentController {
	@Autowired
	IStudentService studentService;
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student savedStudent = studentService.saveStudent(student);
		return ResponseEntity.ok(savedStudent);
		
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudents(@PathVariable Integer id){
		return ResponseEntity.ok(studentService.getStudent(id).get());
	}
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudents(@PathVariable Integer id,@RequestBody Student student){
		return ResponseEntity.ok(studentService.updateStudent(id,student));
	}
	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudents(@PathVariable Integer id){
		try {
			studentService.deleteStudent(id);
		} catch (Exception e) {
			return ResponseEntity.ok( String.format("Error No data found with id %d",id));
		}
		
		return ResponseEntity.ok("Deleted Successfully");
	}
}
