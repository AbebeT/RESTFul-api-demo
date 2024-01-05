package com.example.jpa.repository;

import com.example.jpa.entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepo extends JpaRepository<Passport, Integer> {
    public Passport findPassportByPassportNumber(String passportNumber);
}
