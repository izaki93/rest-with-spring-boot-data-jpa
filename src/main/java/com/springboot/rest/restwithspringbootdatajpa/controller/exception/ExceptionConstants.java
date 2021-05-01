package com.springboot.rest.restwithspringbootdatajpa.controller.exception;

public class ExceptionConstants {

	private ExceptionConstants() {
		throw new IllegalStateException();
	}

	public static final String API_ERROR = "api.error";
	public static final String ENTITY_ADD_EXCEPTION = "api.entity.add.exception";
	public static final String ENTITY_NOT_FOUND = "api.entity.not.found";
	public static final String GENERAL_ERROR = "api.general-error";

}
