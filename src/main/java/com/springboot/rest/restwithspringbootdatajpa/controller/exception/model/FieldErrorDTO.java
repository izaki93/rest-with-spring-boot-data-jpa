package com.springboot.rest.restwithspringbootdatajpa.controller.exception.model;

import lombok.Data;

@Data
public class FieldErrorDTO {
	private String field;
	private String message;

}
