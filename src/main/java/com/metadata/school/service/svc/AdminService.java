package com.metadata.school.service.svc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metadata.school.service.data.Course;
import com.metadata.school.service.data.Student;
import com.metadata.school.service.repository.CourseRepository;
import com.metadata.school.service.repository.StudentRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
@AllArgsConstructor
public class AdminService {

	@Autowired
	@Getter
	private StudentRepository studentRepository;
	
	@Autowired
	@Getter
	private CourseRepository courseRepository;
	
	
	public List<Student> fetchStudentsForGivenCourse(String courseId){
		
		if(courseId == null || courseId.isBlank()) {
			return List.of();
		}
		
		Optional<Course> course =  courseRepository.findById(Integer.parseInt(courseId));
		if(course.isPresent()){
			return course.get().getStudents();
		}
		
		return List.of();
	}
	
	public List<Course> fetchCoursesOfStudent(String studentId){
		
		Optional<Student> student = studentRepository.findById( Integer.parseInt(studentId) );
		if(student.isPresent()) {
			return student.get().getCourses();
		}
		
		return List.of();
	}
	
	public List<Student> fetchAllUnregisteredStudents(){
		return studentRepository.getAllStudentsNotRegistered();
	}
	
	public List<Course> fetchAllUnregisteredCourses(){
		return courseRepository.getAllCoursesNotRegistered();
	}
}
