package com.manageCars.manageCars.resources.exeptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.manageCars.manageCars.servicies.exeptions.DataIntegrityViolationException;
import com.manageCars.manageCars.servicies.exeptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionnHandler {

	// tratamento de exception (ResourceNotFoundException )
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
	 String error = "Recurso não Encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);

	}
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> resourceNotFound(DataIntegrityViolationException e, HttpServletRequest request) {
	 String error = "veifique= a tentativa de Delete ";
		HttpStatus status = HttpStatus.NO_CONTENT;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);

	}

}
