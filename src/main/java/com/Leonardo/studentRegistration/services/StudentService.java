package com.Leonardo.studentRegistration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Leonardo.studentRegistration.entities.Student;
import com.Leonardo.studentRegistration.repository.StudentRepository;

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
	
	public Optional<Student> findById(Long id) {
		return repository.findById(id);
	}
	
	public Student update(Long id, Student obj) {
		Student entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Student entity, Student obj) {
		entity.setCourse(obj.getCourse());
		
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	

}
