package org.nsrfarms.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(WebRequest request,
			ResourceNotFoundException exception) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
				request.getDescription(false), "ITEM_NOT_FOUND");
		ResponseEntity<ErrorDetails> re = new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
		return re;
	}

	@ExceptionHandler(InvalidPriceException.class)
	public ResponseEntity<ErrorDetails> handleInvlidPriceException(WebRequest request,
			InvalidPriceException exception) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
				request.getDescription(false), "INVLID_PRICE");
		ResponseEntity<ErrorDetails> re = new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
		return re;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleException(WebRequest request,
			Exception exception) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
				request.getDescription(false), "INTERNAL_SERVER_ERROR");
		ResponseEntity<ErrorDetails> re = new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
		return re;
	}
}
