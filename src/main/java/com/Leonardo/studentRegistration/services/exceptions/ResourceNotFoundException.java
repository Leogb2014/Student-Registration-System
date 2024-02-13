package com.Leonardo.studentRegistration.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Long id) {
		super("ID: " + id + " not found");
	}

}
