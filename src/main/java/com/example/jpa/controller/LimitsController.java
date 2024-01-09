package com.example.jpa.controller;

import com.example.jpa.config.Configuration;
import com.example.jpa.entities.LimitConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LimitsController {

    private final Configuration configuration;

    public LimitsController(Configuration configuration){
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public ResponseEntity<LimitConfiguration> getLimits() {
        return ResponseEntity.status(HttpStatus.OK).body(LimitConfiguration.builder().minimum(configuration.getMinimum()).maximum(configuration.getMaximum()).build());

    }


}
