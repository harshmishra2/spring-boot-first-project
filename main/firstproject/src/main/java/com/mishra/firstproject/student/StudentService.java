package com.mishra.firstproject.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

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

	public void addNewStudent(Student student) {

		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		
		if(studentOptional.isPresent()) {
			throw new IllegalStateException("Email Taken");
			//this message is displayed when application.properties defines the criteria to display error message
		}
		studentRepository.save(student);
		
	}

	public void deleteStudent(Long studentId) {
		// TODO Auto-generated method stub
		
		boolean exists = studentRepository.existsById(studentId);
		if(!exists) {
			throw new IllegalStateException("student with id "+ studentId + " does not exists");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		// TODO Auto-generated method stub
		
		Student student = studentRepository.findById(studentId).orElseThrow( () -> new IllegalStateException("student with id "+studentId+" does not exists"));
		
		
		if(name != null && name.length()>0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		
		if(email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)) {
			
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			
			if(studentOptional.isPresent()) {
				throw new IllegalStateException("Email Taken");
			}
			
			student.setEmail(email);
			
		}
	}

}
