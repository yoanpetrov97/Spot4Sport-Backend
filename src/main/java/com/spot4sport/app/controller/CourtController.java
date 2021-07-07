package com.spot4sport.app.controller;

import com.spot4sport.app.exception.CourtNotFoundException;
import com.spot4sport.app.model.Court;

import java.util.List;

import com.spot4sport.app.repository.CourtRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class CourtController {

    private final CourtRepository repository;

    public CourtController(CourtRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/courts")
    List<Court> all() {
        return repository.findAll();
    }

    @PostMapping("/courts")
    Court newCourt(@RequestBody Court newCourt) {
        return repository.save(newCourt);
    }


    @GetMapping("/courts/{id}")
    Court one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CourtNotFoundException(id));
    }

    @PutMapping("/courts/{id}")
    Court editCourt(@RequestBody Court newCourt, @PathVariable Long id) {

        return repository.findById(id)
                .map(court -> {
                    court.setName(newCourt.getName());
                    return repository.save(court);
                })
                .orElseThrow(() -> new CourtNotFoundException(id));
    }

    @DeleteMapping("/courts/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
