package com.students.management.system.globalException;

public class StudentNotFound extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFound(String errorMessage)
	{
		super(errorMessage);
	}

}
