package com.mishra.firstproject.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository requires some generic T: The type of object we want this repository to work with
//Id: and id of the type that we want.

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	

}
