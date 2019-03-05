package portfolio.analysis.controller.error;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Displays any request validation errors to the requester in a more readable format.
 * @author Jacob
 *
 */
@ControllerAdvice
public class ValidationErrorsControllerAdvice {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorResponse handleConstraintViolation(ConstraintViolationException e) {
		ValidationErrorResponse error = new ValidationErrorResponse();
		for( ConstraintViolation v : e.getConstraintViolations()) {
			Violation violation = new Violation(v.getPropertyPath().toString(), v.getMessage());	
			error.getViolations().add(violation);
		}
		return error;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationErrorResponse handleMethodNotValidViolation(MethodArgumentNotValidException e) {
		ValidationErrorResponse error = new ValidationErrorResponse();
		for( FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			Violation violation = new Violation(fieldError.getField(), fieldError.getDefaultMessage());	
			error.getViolations().add(violation);
		}
		return error;
	}
	

}
