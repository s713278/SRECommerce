package org.nsrfarms.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@AllArgsConstructor
public class ResourceNotFoundException extends EntityNotFoundException {
	public ResourceNotFoundException(String message) {
		super(message);
	}

	/**
		 * 
		 */
	private static final long serialVersionUID = 1412007057024204616L;

}
