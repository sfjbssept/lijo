package com.student.service;

import java.util.Optional;

import com.student.entity.Student;

public interface IStudentService {
	public Student saveStudent(Student student);
	public Student updateStudent(Integer id, Student student);
	public Optional<Student> getStudent(Integer id);
	public void deleteStudent(Integer id);

}
