package com.metadata.school.service.svc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metadata.school.service.data.Course;
import com.metadata.school.service.data.Student;
import com.metadata.school.service.data.StudentCourse;
import com.metadata.school.service.repository.CourseRepository;
import com.metadata.school.service.repository.StudentCourseRepository;
import com.metadata.school.service.repository.StudentRepository;

import lombok.Getter;

@Service
public class RegistrationService {

	@Autowired
	@Getter
	private StudentRepository studentRepository;

	@Autowired
	@Getter
	private CourseRepository courseRepository;
	
	@Autowired
	@Getter
	private StudentCourseRepository studentCourseRepository;

	public Student getStudent(Integer id) {
		return studentRepository.getById(id);
	}

	public boolean createStudent(Student student) {
		
		if(studentRepository.findById(student.getId()).isEmpty()) {
			studentRepository.saveAndFlush(student); 
			return true; 
		} 

		return false;
	}

	public String updateStudent(Student student, Integer id) {
		Optional<Student> dbSt = studentRepository.findById(id);
		if (dbSt.isPresent()) {
			dbSt.get().setFirstName(student.getFirstName());
			dbSt.get().setLastName(student.getLastName());
			studentRepository.save(dbSt.get());
			return "Student details updated";
		} else {
			return "Student not found";
		}
	}

	public boolean createCourse(Course course) {
		if(courseRepository.findById(course.getId()).isEmpty()) {
			courseRepository.saveAndFlush(course);
			return true;
		}
		return false;
	}

	public String updateCourse(Course course, Integer id) {
		Optional<Course> dbSt = courseRepository.findById(id);
		if (dbSt.isPresent()) {
			dbSt.get().setName(course.getName());
			courseRepository.save(dbSt.get());
			return "Course details updated";
		} else {
			return "Course not found";
		}
	}

	public boolean registerStudentCourse(Integer studentId, Integer courseId) {

		StudentCourse sc = new StudentCourse();
		sc.setCourseId(courseId);
		sc.setStudentId(studentId);
		
		//handle if the course is already registered
		//TODO
		
		// check if student already has max courses
		Integer registeredCount = studentCourseRepository.courseCountByStudentId(studentId);
		if(registeredCount>=5) {
			return false;
		}
		// check if the course already has 50 students
		Integer registeredStudentCount = studentCourseRepository.studentCountByCourseId(courseId);
		if(registeredStudentCount>=50) {
			return false;
		}
		
		
		
		// then register
		studentCourseRepository.save(sc);
		
		return true;
	}

}
