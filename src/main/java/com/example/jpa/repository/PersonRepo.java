package com.example.jpa.repository;

import com.example.jpa.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {
    Page<Person> findAll(Pageable pageable);
}
