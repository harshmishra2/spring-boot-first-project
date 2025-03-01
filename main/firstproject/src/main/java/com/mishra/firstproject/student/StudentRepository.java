package com.mishra.firstproject.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//JpaRepository requires some generic T: The type of object we want this repository to work with
//Id: and id of the type that we want.

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	
	@Query("Select s From Student s where s.email = ?1 ")
	Optional<Student> findStudentByEmail(String email);
	//translates into Select * From student where email == ?
	//JPQL- the Student above is the entity class that we defined earlier.
	

}
