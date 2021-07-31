package com.shrikant.assignment.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.JoinColumn;

@Entity
//@Access(AccessType.PROPERTY)
//@Table(name="student")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "studentid")
public class Student {

	//@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentid;
	
	@Column
	private String studentname;
	
	@Column
	private String phone;

	@Column
	private String email;
	
	
	
	public Student(){}


	
	
	
	//@ManyToMany
	//@ElementCollection(targetClass = Course.class)
	//@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "studentid") }, inverseJoinColumns = { @JoinColumn(name = "courseid") })
	private List<Course> courses;



	public Student(int studentid, String studentname, String phone, String email, List<Course> courses) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.phone = phone;
		this.email = email;
		this.courses = courses;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStudentid() {
		return studentid;
	}



	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}



	public String getStudentname() {
		return studentname;
	}



	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	@ManyToMany(targetEntity = Course.class,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	//@ElementCollection(targetClass = Course.class)
	//@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "studentid") }, inverseJoinColumns = { @JoinColumn(name = "courseid") })
	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
			
	
	 

	
	
}
