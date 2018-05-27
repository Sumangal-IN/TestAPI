package com.kingfisher.orderhub.fulfilmentsource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class S3ServiceIOException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public S3ServiceIOException(String exception) {
		super(exception);
	}
}
