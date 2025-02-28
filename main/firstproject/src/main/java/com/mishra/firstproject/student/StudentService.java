package com.mishra.firstproject.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component we could have use the component annotation but the service annotation is more accurate n specific better to use that

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService (StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents(){
		
		return studentRepository.findAll();
	}

}
