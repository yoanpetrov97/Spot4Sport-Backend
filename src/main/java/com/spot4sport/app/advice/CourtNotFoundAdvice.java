package com.spot4sport.app.advice;

import com.spot4sport.app.exception.CourtNotFoundException;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CourtNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CourtNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String courtNotFoundHandler(CourtNotFoundException ex) {
        return ex.getMessage();
    }
}
