package com.springboot.rest.restwithspringbootdatajpa.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import java.util.Locale;
import java.util.Optional;

@Component
public class MessageResolver {

	private final MessageSource messageSource;
	private static MessageResolver messageResolver;

	public MessageResolver(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@PostConstruct
	public void init() {
		messageResolver = this;
	}

	public static MessageResolver getInstance() {
		return messageResolver;
	}

	public String getMessage(String code) {
		return this.getMessage(code, code);
	}

	public String getMessage(ConstraintViolation error) {
		Object value = Optional.ofNullable(error.getConstraintDescriptor().getAttributes().get("value")).orElse("");
		Object[] args = new Object[]{error.getPropertyPath(), value};
		return this.getMessage(error.getMessage(), args);
	}

	public String getMessage(String code, Object[] args) {
		return messageSource.getMessage(code, args, code, getUserLocale());
	}

	private String getMessage(String code, String defaultMessage) {
		return messageSource.getMessage(code, new Object[0], defaultMessage, getUserLocale());
	}

	private Locale getUserLocale() {
		return LocaleContextHolder.getLocale();
	}


	public String getMessage(MessageSourceResolvable fieldError) {
		return messageSource.getMessage(fieldError, getUserLocale());
	}
}
