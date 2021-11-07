package com.metadata.school.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 
 * @author rajesh
 *
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SchoolRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolRegistrationServiceApplication.class, args);
	}

}
