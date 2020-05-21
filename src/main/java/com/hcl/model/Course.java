
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
@Table(name="courses")
public class Course {
	@Id
	private int id;
	private String coursename;
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.ALL
                })
	 @JoinTable
   @JsonIgnoreProperties(value="courses")
    private List<Student> students = new ArrayList<Student>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", coursename=" + coursename + ", students=" + students + "]";
	}
	public Course(int id, String coursename, List<Student> students) {
		super();
		this.id = id;
		this.coursename = coursename;
		this.students = students;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
