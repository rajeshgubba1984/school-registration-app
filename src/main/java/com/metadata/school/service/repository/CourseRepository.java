package com.metadata.school.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metadata.school.service.data.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	
	@Query("SELECT c "
			+ "FROM Student s, Course c "
			+ "WHERE c.id NOT in "
			+ "(SELECT sc.courseId "
			+ "FROM StudentCourse sc "
			+ "WHERE sc.studentId = s.id AND  "
			+ "sc.courseId = c.id ) ")
	public List<Course> getAllCoursesNotRegistered();
}
