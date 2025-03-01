package com.mishra.firstproject.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			
			Student harsh = (new Student("Harsh", "mishraharsh@gmail.com", LocalDate.of(2002, 01, 11)));
			
		
			Student alex = (new Student("Alex", "Alexji@gmail.com", LocalDate.of(2003, 03, 07)));
			
			repository.saveAll(List.of(harsh, alex));
			
		};
	}
	
}
