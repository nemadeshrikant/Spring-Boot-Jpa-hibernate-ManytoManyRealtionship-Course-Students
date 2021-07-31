package com.shrikant.assignment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.shrikant.assignment.model.Student;
import com.shrikant.assignment.service.CourseService;
import com.shrikant.assignment.service.StudentService;

@RestController
@RequestMapping("/students")
public class RestStudentController {

	
	@Autowired
	StudentService studentService;
	
		    @GetMapping("/students")
	    public ResponseEntity<List<Student>> getAllStudents() {
	        List<Student> students = studentService.getAllStudents();
	        return new ResponseEntity<>(students, HttpStatus.OK);
	    }
		    
		    
	    @PostMapping("/student")
	    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
	        Student std = studentService.addStudent(student);
	        return new ResponseEntity<>(std, HttpStatus.CREATED);
	    }
	    	
}
