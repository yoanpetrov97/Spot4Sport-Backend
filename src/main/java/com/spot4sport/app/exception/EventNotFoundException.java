package com.spot4sport.app.exception;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("Event not find court with id -  " + id);
    }
}
