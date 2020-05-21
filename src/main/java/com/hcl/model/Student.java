package com.hcl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="students")
public class Student {
	@Id
	private int id;
	private String name;
	private String email;
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,mappedBy = "students")
	@JsonIgnoreProperties(value="students")
    private List<Course> courses = new ArrayList<Course>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", courses=" + courses + "]";
	}
	public Student(int id, String name, String email, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.courses = courses;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


}
