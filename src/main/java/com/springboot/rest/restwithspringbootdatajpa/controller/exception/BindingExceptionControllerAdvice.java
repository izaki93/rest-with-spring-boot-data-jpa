package com.springboot.rest.restwithspringbootdatajpa.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BindingExceptionControllerAdvice extends RestControllerAdvice {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> genericExceptionHandler(BindException ex) {
        return transformBindingResult(ex.getBindingResult());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> genericExceptionHandler(MethodArgumentNotValidException ex) {
        return transformBindingResult(ex.getBindingResult());
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> validationExceptionHandler(ConstraintViolationException ex) {
        return ex.getConstraintViolations().stream().map(messageResolver::getMessage)
                .collect(Collectors.toList());
    }

    private List<String> transformBindingResult(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream().map(messageResolver::getMessage)
                .collect(Collectors.toList());
    }

}
