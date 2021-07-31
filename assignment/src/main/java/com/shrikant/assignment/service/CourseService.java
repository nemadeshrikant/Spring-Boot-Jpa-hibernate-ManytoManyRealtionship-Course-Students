package com.shrikant.assignment.service;

import java.util.ArrayList;

import com.shrikant.assignment.model.Course;
import com.shrikant.assignment.repository.CourseRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	
	
	public void addCourse(Course course) {
	 courseRepository.save(course);
		
	}
	

	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	
	/*public void deleteCourse(int id) {
		courseRepository.deleteById(id);
		
	} */
	
	

	
	/*public Course getCourse(int id) {
		
		return courseRepository.findById(id);
	}
	*/
	
	
	
	public List<Course> getAllCoursesByProfessorName(String professorname) {
		// TODO Auto-generated method stub
		return courseRepository.getAllCoursesByProfessorName(professorname);
	}


	@Transactional
	public ResponseEntity<Object> deleteRole(String coursename) {
		 if(courseRepository.findBycoursename(coursename).isPresent()){
	            courseRepository.deleteBycoursename(coursename);
	           
	            
	            if(courseRepository.findBycoursename(coursename).isPresent()){
	                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
	            } else return ResponseEntity.ok().body("Successfully deleted specified record");
	        } else
	            return ResponseEntity.unprocessableEntity().body("No Records Found");
	}

	
	
	
	
	
	
	
	
	

}
