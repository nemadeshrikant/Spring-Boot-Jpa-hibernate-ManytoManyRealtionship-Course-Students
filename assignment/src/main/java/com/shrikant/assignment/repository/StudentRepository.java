package com.shrikant.assignment.repository;

import org.springframework.data.repository.CrudRepository;

import com.shrikant.assignment.model.Course;
import com.shrikant.assignment.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

	Student getOne(Integer id);

}
