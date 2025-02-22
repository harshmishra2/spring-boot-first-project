package com.mishra.firstproject.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

//@Component we could have use the component annotation but the service annotation is more accurate n specific better to use that

@Service
public class StudentService {
	
	public List<Student> getStudents(){
		return List.of(new Student(1L, "Harsh", "mishraharsh@gmail.com", LocalDate.of(2002, 01, 11), 23));
	}

}
