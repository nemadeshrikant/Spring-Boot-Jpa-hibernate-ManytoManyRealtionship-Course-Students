package com.shrikant.assignment.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrikant.assignment.model.Course;
import com.shrikant.assignment.model.Student;
import com.shrikant.assignment.repository.CourseRepository;
import com.shrikant.assignment.repository.StudentRepository;


@Service
public class StudentService {


@Autowired
private StudentRepository studentRepository;
@Autowired
private CourseRepository courseRepository;

public Student addStudent(Student student) {
	return studentRepository.save(student);
	
}


public List<Student> getAllStudents() {
	
	List<Student> students= new ArrayList<>();
	studentRepository.findAll().forEach(students::add);
	return students;
}

public Optional<Student> getStudent(int id) {
	
	return studentRepository.findById(id);
}

}