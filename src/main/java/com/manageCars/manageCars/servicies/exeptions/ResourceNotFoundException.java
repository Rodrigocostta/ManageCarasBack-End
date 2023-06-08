package com.manageCars.manageCars.servicies.exeptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Não temos esse - "+id);
	}
	

}
