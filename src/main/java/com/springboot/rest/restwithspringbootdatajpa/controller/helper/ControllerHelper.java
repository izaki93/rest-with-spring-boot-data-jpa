package com.springboot.rest.restwithspringbootdatajpa.controller.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.rest.restwithspringbootdatajpa.controller.exception.model.RestExceptionDTO;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.springboot.rest.restwithspringbootdatajpa.controller.ControllerConstants.*;

@Slf4j
public class ControllerHelper {

    public static String toJsonString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
            result = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.info("Can't convert to json string : " + obj.toString());
        }
        return result;
    }

    public static void logRequest(HttpServletRequest request, String userId, String functionName, String extendedDetails) {
        log(request, LOG_REQUEST, userId, functionName, "", extendedDetails);
    }

    public static void logResponse(HttpServletRequest request, String userId, String functionName, String httpStatus, String extendedDetails) {
        log(request, LOG_RESPONSE, userId, functionName, httpStatus, extendedDetails);
    }

    private static void log(HttpServletRequest request, String type, String userId, String functionName, String httpStatus, String extendedDetails) {
        log.info("{\"prefix\":\"{}\", \"timestamp\":\"{}\", \"type\":\"{}\", \"user_id\":\"{}\", \"headers\":{}, \"url\":\"{}\", "
                        + "\"function_name\":\"{}\", \"action\":\"{}\", \"http_status\":\"{}\", \"extended_details\":{} }",
                LOG_PREFIX, Instant.now(), type, userId == "" ? "{}" : userId, "{}"/*getHeaders(request)*/,
                request.getRequestURL(), functionName, request.getMethod(), httpStatus, extendedDetails == "" ? "{}" : extendedDetails);
    }

    public static void logException(RestExceptionDTO restExceptionDTO, Throwable ex) {
        log.error("{\"securityPrefix\":\"{}\", \"timestamp\":\"{}\", \"http_status\":\"{}\", \"extended_details\":{} }",
                LOG_PREFIX, Instant.now(), restExceptionDTO.getCode(),
                "{\"stackTrace\":\"" + Arrays.toString(ex.getStackTrace()) + "\", \"message\":\"" + restExceptionDTO.getMessage() + "\"}");
    }

    public static void logException(List<String> message, String httpCode, Throwable ex) {
        log.error("{\"securityPrefix\":\"{}\", \"timestamp\":\"{}\", \"http_status\":\"{}\", \"extended_details\":{} }",
                LOG_PREFIX, Instant.now(), httpCode,
                "{\"stackTrace\":\"" + Arrays.toString(ex.getStackTrace()) + "\", \"message\":\"" + toJsonString(message) + "\"}");
    }

    /*private static String getHeaders(HttpServletRequest request) {
        return "{\"" + HEADER_ROLE + "\":\"" + getEmptyStringIfNull(request.getHeader(HEADER_ROLE)) + "\", \""
                + HEADER_ESTABLISHMENT +"\":\"" + getEmptyStringIfNull(request.getHeader(HEADER_ESTABLISHMENT)) + "\", \""
                + HEADER_ORGANIZATION + "\":\"" + getEmptyStringIfNull(request.getHeader(HEADER_ORGANIZATION)) +
                "\"}";
    }*/

    private static String getEmptyStringIfNull(String value) {
        return Objects.nonNull(value) ? value : "";
    }

}
