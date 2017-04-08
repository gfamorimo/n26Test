package com.gabrielfao.n26.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NO_CONTENT) 
public class ValidatorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7556844801106592359L;

}
