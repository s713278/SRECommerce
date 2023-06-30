package org.nsrfarms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@AllArgsConstructor
public class InvalidPriceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4676218723586949962L;

	public InvalidPriceException(String message) {
		super(message);
	}
}
