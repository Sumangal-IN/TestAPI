package com.kingfisher.orderhub.fulfilmentsource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class NoFulfilementSourceExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoFulfilementSourceExistsException(String exception) {
		super(exception);
	}
}
