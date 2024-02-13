package com.Leonardo.studentRegistration.configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Leonardo.studentRegistration.entities.Student;
import com.Leonardo.studentRegistration.enums.Course;
import com.Leonardo.studentRegistration.repository.StudentRepository;

@Configuration
public class config implements CommandLineRunner{
	
	@Autowired
	private StudentRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Student st1 = new Student(null, "Bob", sdf.parse("10/05/1997"), Course.TECNOLOGY);
		Student st2 = new Student(null, "Maria", sdf.parse("20/09/1990"), Course.MEDICINE);
		
		repository.saveAll(Arrays.asList(st1, st2));
		
		
	}

}
