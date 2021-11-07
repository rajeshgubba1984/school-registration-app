package com.metadata.school.service.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "COURSE" )
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4191122019151404041L;

	@Id
    @Column( name = "Id" )
    private Integer id;
	
	@Column( name = "Name")
	private String name;
	
	@JsonBackReference
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name = "STUDENT_COURSE", 
        joinColumns = { @JoinColumn(name = "student_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
	private List<Student> students;
}
