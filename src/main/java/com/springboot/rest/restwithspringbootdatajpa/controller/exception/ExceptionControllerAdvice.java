package com.springboot.rest.restwithspringbootdatajpa.controller.exception;

import com.springboot.rest.restwithspringbootdatajpa.controller.exception.model.RestExceptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

import static com.springboot.rest.restwithspringbootdatajpa.controller.exception.ExceptionConstants.ENTITY_NOT_FOUND;

@Slf4j
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class ExceptionControllerAdvice extends RestControllerAdvice {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    public RestExceptionDTO entityNotFoundExceptionHandler(HttpServletResponse resp, EntityNotFoundException ex) {
        return buildExceptionDTO(resp, ENTITY_NOT_FOUND, ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
