package com.Leonardo.studentRegistration.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.Leonardo.studentRegistration.enums.Course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date birthDate;
	
	private Integer course;
	
	public Student() {
		
	}

	public Student(Long id, String name, Date birthDate, Course course) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		setCourse(course);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Course getCourse() {
		return Course.valueOf(course);
	}

	public void setCourse(Course course) {
		if(course != null) {
		     this.course = course.getCode();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
