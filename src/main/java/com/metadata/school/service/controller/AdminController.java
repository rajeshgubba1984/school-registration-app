package com.metadata.school.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metadata.school.service.data.Course;
import com.metadata.school.service.data.Student;
import com.metadata.school.service.repository.CourseRepository;
import com.metadata.school.service.repository.StudentRepository;
import com.metadata.school.service.svc.AdminService;

/**
 * Controller for admin related operations
 * @author rajes
 *
 */
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin/students")
	public List<Student> getAllStudentsByCourseId(@RequestParam(name = "course_id") String courseId) {
		
		if(courseId == null || courseId.isBlank()) {
			return adminService.fetchAllUnregisteredStudents();
		}
		
		return adminService.fetchStudentsForGivenCourse(courseId);
	}
	
	@GetMapping("/admin/courses")
	public List<Course> getAllCoursesByStudentId(@RequestParam(name = "student_id") String studentId) {
		if(studentId == null || studentId.isBlank()) {
			return adminService.fetchAllUnregisteredCourses();
		}
		
		return adminService.fetchCoursesOfStudent(studentId);
	}
	
}
