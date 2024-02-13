package com.Leonardo.studentRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Leonardo.studentRegistration.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
