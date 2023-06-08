package com.manageCars.manageCars.servicies.exeptions;

public class DataIntegrityViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public DataIntegrityViolationException(Object id) {
		super(" A exclusão não pode ser feita");
	}

}
