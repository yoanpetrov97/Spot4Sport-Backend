package com.spot4sport.app.controller;

import com.spot4sport.app.exception.EventNotFoundException;

import java.util.List;

import com.spot4sport.app.model.Event;
import com.spot4sport.app.repository.EventRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class EventController {

    private final EventRepository repository;

    public EventController(EventRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/events")
    List<Event> all() {
        return repository.findAll();
    }

    @PostMapping("/events")
    Event newEvent(@RequestBody Event newEvent) {
        return repository.save(newEvent);
    }


    @GetMapping("/events/{id}")
    Event one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    @PutMapping("/events/{id}")
    Event editEvent(@RequestBody Event newEvent, @PathVariable Long id) {

        return repository.findById(id)
                .map(event -> {
                    event.setName(newEvent.getName());
                    return repository.save(event);
                })
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    @DeleteMapping("/events/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

