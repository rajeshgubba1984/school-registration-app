package com.metadata.school.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metadata.school.service.data.Student;
import com.metadata.school.service.svc.RegistrationService;

/**
 * Controller for student related operations
 * @author rajes
 *
 */
@RestController
public class StudentController {

	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/students")
	public List<Student> getAll() {
		return registrationService.getStudentRepository().findAll();
	}
	
	@PostMapping(path = "/student/add", consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE},
			headers="Accept=application/json")
	public ResponseEntity<String> add(@RequestBody Student student) {
		
		if(registrationService.createStudent(student)) {
			return ResponseEntity.ok("success");
		}
		
		//TODO: need to return different type of responses based on type of failure reason & status code
		
		return ResponseEntity.ok("failed! already exists.");
	}
	
	@DeleteMapping("/student/{id}")
	public void delete(@PathVariable Integer id) {
		registrationService.getStudentRepository().deleteById(id);
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<String> update(@RequestBody Student student, @PathVariable Integer id) {
		return ResponseEntity.ok(registrationService.updateStudent(student, id));
	}
	
	@GetMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<String> register(@PathVariable Integer studentId, @PathVariable Integer courseId) {
		if(registrationService.registerStudentCourse(studentId, courseId)) {
			return ResponseEntity.ok("success");
		}else {
			return ResponseEntity.ok("failed");
		}
		//TODO: need to return different type of responses based on type of failure reason & status code
		
	}
}
