package com.ajith.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ControllerAdvice {

        Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ExceptionHandler(Exception.class)
        public Map<String, Object> thrownError(Exception e){
            Map<String,Object> response = new HashMap<>();
            response.put("message",e.getMessage());
            response.put("cause",e.getCause());
            response.put("localized",e.getLocalizedMessage());
            response.put("supressed",e.getSuppressed());
            logger.info("Exception Error: {}",e.getLocalizedMessage());
            return response;
        }
}
