package com.spot4sport.app.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(Long id) {
        super("Person not find court with id -  " + id);
    }
}
