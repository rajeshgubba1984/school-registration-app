package com.metadata.school.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metadata.school.service.data.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer>{

	@Query("SELECT count(*) from StudentCourse sc where sc.studentId = :studentId ")
	public Integer courseCountByStudentId(@Param("studentId") Integer sid);
	
	@Query("SELECT count(*) from StudentCourse sc where sc.courseId = :courseId ")
	public Integer studentCountByCourseId(@Param("courseId") Integer cid);
	
}
