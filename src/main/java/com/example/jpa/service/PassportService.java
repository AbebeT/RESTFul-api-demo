package com.example.jpa.service;

import com.example.jpa.entities.Passport;
import com.example.jpa.repository.PassportRepo;
import com.example.jpa.utilities.Helper;
import com.example.jpa.dto.PassportDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PassportService {
    private PassportRepo passportRepo;

    public PassportService(PassportRepo passportRepo) {
        this.passportRepo = passportRepo;
    }

    public void savePassport(PassportDto passport) {
        Passport passportEntity = new Passport();
        if(passport !=null) {
            passportEntity = this.passportRepo.findPassportByPassportNumber(passport.getPassportNumber());
        }
        if(passportEntity !=null ) {
            passportEntity.setPassportNumber(passport.getPassportNumber());
            passportEntity.setPerson(passport.getPerson());
        } else {
            passportEntity = Helper.toEntity(passport);
        }
        this.passportRepo.save(passportEntity);
    }

    public PassportDto getPassport(int id) {
        Optional<Passport> passport = this.passportRepo.findById(id);
        return passport.isPresent() ? Helper.toDto(passport.get()) : null;
    }

    public List<PassportDto> getAllPassports() {
        return this.passportRepo.findAll().stream()
                .map(passport -> Helper.toDto(passport)).collect(Collectors.toList());
    }
}
