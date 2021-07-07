package com.spot4sport.app.controller;

import java.util.List;

import com.spot4sport.app.exception.ReservationNotFoundException;
import com.spot4sport.app.model.Reservation;
import com.spot4sport.app.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class ReservationController {

    private final ReservationRepository repository;

    public ReservationController(ReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reservations")
    List<Reservation> all() {
        return repository.findAll();
    }

    @PostMapping("/reservations")
    Reservation newReservation(@RequestBody Reservation newReservation) {
        return repository.save(newReservation);
    }


    @GetMapping("/reservations/{id}")
    Reservation one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
    }

    @DeleteMapping("/reservations/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
