package com.metadata.school.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metadata.school.service.data.Course;
import com.metadata.school.service.svc.RegistrationService;

/**
 * Controller for course related operations
 * @author rajes
 *
 */
@RestController
public class CourseController {

	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/courses")
	public List<Course> getAll() {
		return registrationService.getCourseRepository().findAll();
	}
	
	@PostMapping("/course/add")
	public ResponseEntity<String> add(@RequestBody Course course) {
		if(registrationService.createCourse(course)) {
			return ResponseEntity.ok("success!");
		}
		return ResponseEntity.ok("failed! course already exists!");
	}
	
	@DeleteMapping("/course/{id}")
	public void delete(@PathVariable Integer id) {
		
	}
	
	@PutMapping("/course/{id}")
	public void update() {
		
	}
	
}
