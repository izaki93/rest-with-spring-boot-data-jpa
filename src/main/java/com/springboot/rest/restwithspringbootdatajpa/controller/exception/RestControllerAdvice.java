package com.springboot.rest.restwithspringbootdatajpa.controller.exception;

import com.springboot.rest.restwithspringbootdatajpa.controller.MessageResolver;
import com.springboot.rest.restwithspringbootdatajpa.controller.exception.model.RestExceptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

public class RestControllerAdvice {
    @Autowired
    protected MessageResolver messageResolver;

    protected RestExceptionDTO buildExceptionDTO(HttpServletResponse response, String code, String description, HttpStatus status) {
        String errorMessage = messageResolver.getMessage(code);
        RestExceptionDTO result = new RestExceptionDTO();
        result.setMessage(errorMessage);
        response.setStatus(status.value());
        result.setType(status.getReasonPhrase());
        result.setCode(status.value());
        result.setDetails(description);
        return result;
    }

    protected RestExceptionDTO buildExceptionDTO(HttpServletResponse response, String code, String description, HttpStatus status, String serviceName) {
        RestExceptionDTO restExceptionDTO = buildExceptionDTO(response, code, description, status);
        restExceptionDTO.setServiceName(serviceName);
        return restExceptionDTO;
    }
}
