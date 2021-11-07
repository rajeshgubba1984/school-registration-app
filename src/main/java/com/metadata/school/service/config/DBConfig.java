package com.metadata.school.service.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.MySQLContainer;

@Configuration
public class DBConfig {

    private static final String DATABASE_NAME = "REGISTRATION";
    private static final int DATABASE_PORT = 3306;
    private static final String DATABASE_USERNAME = "test";
    private static final String DATABASE_PASSWORD = "test";
    
	private static final MySQLContainer<?> MYSQL_CONTAINER =
	        new MySQLContainer<>( "mysql:5.7.12" ).withExposedPorts( DATABASE_PORT )
	            .withDatabaseName( DATABASE_NAME )
	            .withUsername( DATABASE_USERNAME )
	            .withPassword( DATABASE_PASSWORD );

    static
    {
        MYSQL_CONTAINER.start();
    }
    
    /**
     * Configuration for test mysql.
     *
     * @return a test dataSource
     */
    @Bean
    public DataSource dataSource()
    {
        String url = String.format( "jdbc:mysql://%s:%d/%s", MYSQL_CONTAINER.getContainerIpAddress(),
            MYSQL_CONTAINER.getMappedPort( DATABASE_PORT ), DATABASE_NAME );

        return DataSourceBuilder.create()
            .url( url )
            .username( DATABASE_USERNAME )
            .password( DATABASE_PASSWORD )
            .build();
    }
	    
}
