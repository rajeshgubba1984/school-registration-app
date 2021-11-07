package com.metadata.school.service.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "STUDENT_COURSE" )
public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id" )
    private Integer id;
	
	@Column( name = "student_id" )
    private Integer studentId;
	
	@Column( name = "course_id" )
    private Integer courseId;
}
