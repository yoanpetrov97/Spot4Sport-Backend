package com.spot4sport.app.controller;

import com.spot4sport.app.exception.PersonNotFoundException;
import com.spot4sport.app.model.Person;

import java.util.List;

import com.spot4sport.app.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons")
    List<Person> all() {
        return repository.findAll();
    }

    @PostMapping("/persons")
    Person newPerson(@RequestBody Person newPerson) {
        return repository.save(newPerson);
    }


    @GetMapping("/persons/{id}")
    Person one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PutMapping("/persons/{id}")
    Person editPerson(@RequestBody Person newPerson, @PathVariable Long id) {

        return repository.findById(id)
                .map(Person -> {
                    Person.setName(newPerson.getName());
                    return repository.save(Person);
                })
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @DeleteMapping("/persons/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
