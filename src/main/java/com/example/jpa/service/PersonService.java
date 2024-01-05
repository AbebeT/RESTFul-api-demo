package com.example.jpa.service;


import com.example.jpa.config.PersonSpecification;
import com.example.jpa.entities.Passport;
import com.example.jpa.entities.Person;
import com.example.jpa.repository.PersonRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepo personRepo;
    public PersonService(PersonRepo personRepo){
        this.personRepo = personRepo;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void savePerson(Person person){
        Person newPerson = Person.builder()
                .name(person.getName())
                .build();
        Passport newPassport = Passport
                .builder()
                .passportNumber(person.getPassport().getPassportNumber())
                .person(newPerson)
                .build();
        newPerson.setPassport(newPassport);

        this.personRepo.save(newPerson);
    }

    public Person getPerson(int id) {
        return this.personRepo.findById(id).orElse(null);
    }

    public List<Person> getAllPersons(String name) {
        if(name != null) {
            Specification<Person> spec = Specification.where(null);
            spec = spec.and(PersonSpecification.hasName(name));
            return this.personRepo.findAll(spec);
        }
        return this.personRepo.findAll();
    }
    public Page<Person> getAllPersonsPagenated(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return this.personRepo.findAll(pageRequest);
    }
}
