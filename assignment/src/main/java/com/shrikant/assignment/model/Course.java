package com.shrikant.assignment.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
//@Access(AccessType.PROPERTY)
//@Table(name="course")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "courseid")
public class Course {

	
	//@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseid;
	
	@Column
	private String coursename;
	
	@Column
	private String professorName;
	
	@Column
	private String description;
	
	
	
	public Course(){
		
	}
	
		
	public String getProfessorName() {
		return professorName;
	}


	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}


	//@ManyToMany(mappedBy="courses")
	//@ElementCollection(targetClass = Student.class)
	private List<Student> students;



	


	public Course(int courseid, String coursename, String professorName, String description, List<Student> students) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.professorName = professorName;
		this.description = description;
		this.students = students;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourseid() {
		return courseid;
	}



	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}



	public String getCoursename() {
		return coursename;
	}



	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}



	


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	@ManyToMany(mappedBy="courses",targetEntity = Student.class,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE})
	//@ElementCollection(targetClass = Student.class)
	public List<Student> getStudents() {
		return students;
	}



	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
	
	

}
