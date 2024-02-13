package com.Leonardo.studentRegistration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Leonardo.studentRegistration.entities.Student;
import com.Leonardo.studentRegistration.repository.StudentRepository;
import com.Leonardo.studentRegistration.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public Student registerStudent(Student student) {
		return repository.save(student);
		
	}
	
	public List<Student> findAll(){
		return repository.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Student update(Long id, Student obj) {
		try {
		    Student entity = repository.getReferenceById(id);
		    updateData(entity, obj);
		    return repository.save(entity);
		}catch(EntityNotFoundException e){
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Student entity, Student obj) {
		entity.setCourse(obj.getCourse());
		
	}
	
	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	

}
