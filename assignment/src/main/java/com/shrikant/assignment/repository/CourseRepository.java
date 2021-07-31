package com.shrikant.assignment.repository;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shrikant.assignment.model.Course;
public interface CourseRepository extends CrudRepository<Course, String> {

	Iterable<Course> findAll();

	//public Course findByName(String coursename);

	//void deleteById(int id);

	List<Course> getAllCoursesByProfessorName(String professorName);

	Optional <Course> findBycoursename(String coursename);

	@Modifying
	@Transactional
	@Query(value ="DELETE FROM  course c WHERE  c.coursename=:coursename" , nativeQuery = true)
	void deleteBycoursename(@Param("coursename") String coursename);

	//Course findById(int id);
	
	
	
}
