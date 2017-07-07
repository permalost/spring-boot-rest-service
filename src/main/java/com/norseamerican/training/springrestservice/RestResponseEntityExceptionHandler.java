
package com.norseamerican.training.springrestservice;

import java.util.ArrayList;
import java.util.Collection;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ConstraintViolationException.class})
    protected ResponseEntity<Object> handleNotAuthenticated(RuntimeException ex, WebRequest request) {

		ConstraintViolationException test = (ConstraintViolationException) ex;
		Collection<Issues> issues = new ArrayList();
		
		test.getConstraintViolations().stream().forEach((constraintViolation) ->
		{
			issues.add(new Issues(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()));
		});

        return handleExceptionInternal(ex, issues, 
          new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
    }
	
	private static class Issues{
		private final String parameter;
		private final String error;

		public Issues(String parameter, String error)
		{
			this.parameter = parameter;
			this.error = error;
		}

		public String getParameter()
		{
			return parameter;
		}

		public String getError()
		{
			return error;
		}
		
	}

}