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

import static com.springboot.rest.restwithspringbootdatajpa.controller.exception.ExceptionConstants.API_ERROR;
import static com.springboot.rest.restwithspringbootdatajpa.controller.exception.ExceptionConstants.ENTITY_NOT_FOUND;
import static com.springboot.rest.restwithspringbootdatajpa.controller.helper.ControllerHelper.logException;

@Slf4j
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class ExceptionControllerAdvice extends RestControllerAdvice {

    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public RestExceptionDTO genericExceptionHandler(HttpServletResponse resp, Throwable ex) {
        log.error("API exception", ex);
        RestExceptionDTO restExceptionDTO = buildExceptionDTO(resp, API_ERROR, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        logException(restExceptionDTO, ex);
        return restExceptionDTO;
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    public RestExceptionDTO entityNotFoundExceptionHandler(HttpServletResponse resp, EntityNotFoundException ex) {
        RestExceptionDTO restExceptionDTO = buildExceptionDTO(resp, ENTITY_NOT_FOUND, ex.getMessage(), HttpStatus.NOT_FOUND);
        logException(restExceptionDTO, ex);
        return restExceptionDTO;
    }

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public RestExceptionDTO illegalArgumentExceptionHandler(HttpServletResponse resp, IllegalArgumentException ex) {
        RestExceptionDTO restExceptionDTO = buildExceptionDTO(resp, API_ERROR, ex.getMessage(), HttpStatus.BAD_REQUEST);
        logException(restExceptionDTO, ex);
        return restExceptionDTO;
    }
}
