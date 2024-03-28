package com.asmatech.book.error;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> handlerRecordNotFoundException(RecordNotFoundException exception){
		
		ErrorResponse error = new ErrorResponse(exception.getMessage(), Arrays.asList(exception.getLocalizedMessage()));
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(error);
	}
	
	
	@ExceptionHandler(DaplicateRecordException.class)
	public ResponseEntity<?> handlerDaplicateRecordException(DaplicateRecordException exception){
		
		ErrorResponse error = new ErrorResponse(exception.getMessage(), Arrays.asList(exception.getLocalizedMessage()));
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(error);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ArrayList<String> errors = new ArrayList<>();
		
		for(FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getDefaultMessage());
		}
		
		for(ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getDefaultMessage());
		}
		
		ErrorResponse error = new ErrorResponse(ex.toString(), errors);
		
		
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(error);
	}
}
