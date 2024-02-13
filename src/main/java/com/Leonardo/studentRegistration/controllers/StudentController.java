package com.Leonardo.studentRegistration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Leonardo.studentRegistration.entities.Student;
import com.Leonardo.studentRegistration.services.StudentService;

@RestController
@RequestMapping(value="/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	@PostMapping
	public ResponseEntity<Student> registerStudent(@RequestBody Student obj){
		service.registerStudent(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> findAll(){
		List<Student> students = service.findAll();
		return ResponseEntity.ok().body(students);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Student> findById(@PathVariable Long id){
		Student obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Student obj){
		service.update(id, obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

}
