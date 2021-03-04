package com.devsuperior.dslearnbds.service.exceptions;


public class ForbiddenException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	
	// essa classe retorna 403 response
	public ForbiddenException(String msg) {
		super(msg);
	}
}