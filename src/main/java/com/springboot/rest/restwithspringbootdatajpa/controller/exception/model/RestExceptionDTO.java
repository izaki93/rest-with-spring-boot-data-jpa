package com.springboot.rest.restwithspringbootdatajpa.controller.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestExceptionDTO {
	private int code;
	private String type;
	private String message;
	private String details;
	private String stackTrace;
	private String serviceName;
}
