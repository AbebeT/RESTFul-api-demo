package com.example.jpa.config;

import com.example.jpa.entities.Person;
import org.springframework.data.jpa.domain.Specification;

public class PersonSpecification {
    public static Specification<Person> hasName(String name){
        return (root, query, builder) -> builder.equal(root.get("name"), name);
    }
}
