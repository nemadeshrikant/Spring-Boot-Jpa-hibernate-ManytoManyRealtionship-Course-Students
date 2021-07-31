package com.shrikant.assignment.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shrikant.assignment.model.Course;
import com.shrikant.assignment.repository.CourseRepository;
import com.shrikant.assignment.service.CourseService;

import java.util.*;

@RestController
@RequestMapping("/courses")
public class RestCourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/add")
	public void addcourse(@RequestBody Course course){
		courseService.addCourse(course);
	}
	
	
	
	@GetMapping(value="/list")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping(value="/list/{professorname}")
	public List<Course> getAllCoursesByProfessorName(@PathVariable("professorname") String professorname){
		return courseService.getAllCoursesByProfessorName(professorname);
	}
	
	@GetMapping("/course/details/{coursename}")
	public Course getCourse(@PathVariable String coursename) {
	    if(courseRepository.findBycoursename(coursename).isPresent())
	        return courseRepository.findBycoursename(coursename).get();
	    else return null;
		}
	
	
	
	
	@DeleteMapping("/course/delete/{coursename}")
    public ResponseEntity<Object> deleteRole(@PathVariable String coursename) {
        return courseService.deleteRole(coursename);
    }
}





