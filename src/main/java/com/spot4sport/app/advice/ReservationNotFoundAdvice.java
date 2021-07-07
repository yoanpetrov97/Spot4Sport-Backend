package com.spot4sport.app.advice;

import com.spot4sport.app.exception.PersonNotFoundException;
import com.spot4sport.app.exception.ReservationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ReservationNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ReservationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String courtNotFoundHandler(ReservationNotFoundException ex) {
        return ex.getMessage();
    }
}
