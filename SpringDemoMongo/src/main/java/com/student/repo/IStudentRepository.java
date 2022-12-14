package com.student.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;

@Repository
public interface IStudentRepository extends MongoRepository<Student, Integer> {

}
