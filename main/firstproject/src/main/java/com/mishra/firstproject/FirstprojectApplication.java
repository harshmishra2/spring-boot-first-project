package com.mishra.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.mishra.firstproject.student")
public class FirstprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}
	
	

}

/*
 * I have been encountering the Whitelabel error page for past few hours now. You should know how to fix one.
 * Why does the whitelabel error appear in the first place?
 * 
 * 1. Make sure this file, the main method should be in a package over all the other packages to easily read them all. eg.controller, service.
 * 2. Until the package is able to locate the controller the error will persist. So use @ComponentScan annotation below the @SpringBootApplication
 * 		with the controller class base package location.
 * 3. Make sure the api end-points are being used correctly.
 * 
 */