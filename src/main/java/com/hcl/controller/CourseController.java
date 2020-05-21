package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Course;
import com.hcl.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	CourseService courseService;
	@GetMapping("/courses")
	public ResponseEntity<String> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/course/{courseId}")
	public ResponseEntity<String> getCourseById(@PathVariable String courseId){
		return courseService.getCourseById(courseId);
	}
	
	@GetMapping("/course")
	public ResponseEntity<String> getCourseIdByParam(@RequestParam String courseId){
		return courseService.getCourseByRequestParam(courseId);
	}
	@PostMapping("/course")
	public ResponseEntity<String> addCourse(@RequestBody Course course){
		
		return courseService.saveCourse(course);
			
	}
	

}
