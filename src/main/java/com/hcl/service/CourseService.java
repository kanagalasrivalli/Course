package com.hcl.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.hcl.model.Course;
@Service
public class CourseService {
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


	public ResponseEntity<String> getAllCourses() {
		String course = restTemplate.getForObject("http://localhost:8091/courses", String.class);
		return new ResponseEntity<String>(course,HttpStatus.OK);
	}

	public ResponseEntity<String> getCourseById(String courseId) {
		String course = restTemplate.getForObject("http://localhost:8091/courses", String.class);
		return new ResponseEntity<String>(course,HttpStatus.OK);
	}

	public ResponseEntity<String> getCourseByRequestParam(String courseId) {
		String url = "http://localhost:8080/course/" + courseId;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		Map<String, String> params = new HashMap<String, String>();
		params.put("courseId", courseId);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		for (Map.Entry<String, String> entry : params.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}

		String result = restTemplate.getForObject(builder.toUriString(), String.class);
		return new ResponseEntity<String>(result,HttpStatus.OK);

	}

	public ResponseEntity<String> saveCourse(Course course) {
		String uri = "http://localhost:8091/course";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject request = new JSONObject();
		request.put("courseId", course.getId());
		request.put("coursename", course.getCoursename());
		
		

		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

		ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);

		System.out.println(response);
		return response;
	}

}
