package com.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repo.IStudentRepository;
@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	IStudentRepository studentRepository;
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Integer id, Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Student> getStudent(Integer id) {
		return studentRepository.findById(id);
	}

	@Override
	public void deleteStudent(Integer id) {
		
		 studentRepository.deleteById(id);
	}

}
