package com.spot4sport.app.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id) {
        super("Person not find court with id -  " + id);
    }
}
