package com.Leonardo.studentRegistration.enums;

public enum Course {
	
	TECNOLOGY(1),
	MEDICINE(2),
	LAW(3),
	JOURNALISM(4);
	
	private int code;
	
	private Course(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Course valueOf(int code) {
		for(Course value : Course.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Course code!");
	}

}
