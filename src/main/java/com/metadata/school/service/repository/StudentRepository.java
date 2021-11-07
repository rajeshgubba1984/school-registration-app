package com.metadata.school.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metadata.school.service.data.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("SELECT s "
			+ "FROM Student s, Course c "
			+ "WHERE s.id NOT in "
			+ "(SELECT sc.studentId "
			+ "FROM StudentCourse sc "
			+ "WHERE sc.studentId = s.id AND  "
			+ "sc.courseId = c.id ) ")
	public List<Student> getAllStudentsNotRegistered();
}
