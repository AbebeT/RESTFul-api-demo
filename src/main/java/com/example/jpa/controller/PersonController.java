package com.example.jpa.controller;

import com.example.jpa.entities.Person;
import com.example.jpa.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public ResponseEntity savePerson(@RequestBody Person person) {
        try {
            this.personService.savePerson(person);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        try {
            Person person = this.personService.getPerson(id);
            if (person == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.status(HttpStatus.OK).body(this.personService.getPerson(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons(@RequestParam(required = false, name = "name") String name,
                                                      @RequestParam(required = false, name = "pageSize", defaultValue = "10") int pageSize,@RequestParam(required = false, name = "pageNumber", defaultValue = "0") int pageNumber
    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.personService.getAllPersons(name));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getAllPersonsPaginated")
    public ResponseEntity<Page<Person>> getAllPersonsPaginated( @RequestParam(required = false, name = "pageSize", defaultValue = "2") int pageSize, @RequestParam(required = false, name = "pageNumber", defaultValue = "0") int pageNumber
    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.personService.getAllPersonsPagenated(pageNumber, pageSize));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
