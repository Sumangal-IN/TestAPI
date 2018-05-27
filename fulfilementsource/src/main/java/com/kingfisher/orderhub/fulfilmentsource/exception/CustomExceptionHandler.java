package com.kingfisher.orderhub.fulfilmentsource.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.kingfisher.orderhub.fulfilmentsource.domain.ExceptionResponse;

@ControllerAdvice
public class CustomExceptionHandler {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(S3ServiceIOException.class)
	public ResponseEntity<ExceptionResponse> S3ServiceIOExceptionHandler(
			final S3ServiceIOException e, WebRequest request) {
		LOGGER.error("Error : " + e.getMessage());
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
				"Access to data file failed", request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,
				HttpStatus.SERVICE_UNAVAILABLE);
	}

	@ExceptionHandler(NoFulfilementSourceExistsException.class)
	public ResponseEntity<ExceptionResponse> NoFulfilementSourceExistsExceptionHandler(
			final NoFulfilementSourceExistsException e, WebRequest request) {
		LOGGER.error("Error : " + e.getMessage());
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
				"No Fulfilement Souce found", request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
