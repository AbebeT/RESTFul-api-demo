package com.example.jpa.controller;

import com.example.jpa.entities.Passport;
import com.example.jpa.service.PassportService;
import com.example.jpa.dto.PassportDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PassportController {
    private PassportService passportService;
    public PassportController(PassportService passportService){
        this.passportService = passportService;
    }


//     need to return created response
    @PostMapping("/save-passport")
    public ResponseEntity<Passport> savePassport(@RequestBody PassportDto passport) {
        this.passportService.savePassport(passport);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/get-passport/{id}")
    public ResponseEntity<PassportDto> getPassport(@PathVariable int id) {
        try {
            PassportDto passportDto = this.passportService.getPassport(id);
            return ResponseEntity.ok(passportDto);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/get-all-passports")
    public ResponseEntity<List<PassportDto>> getAllPassports() {
        try {
            List<PassportDto> passportDtos = this.passportService.getAllPassports();
            return ResponseEntity.ok(passportDtos);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
