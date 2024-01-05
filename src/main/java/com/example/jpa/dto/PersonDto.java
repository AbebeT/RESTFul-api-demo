package com.example.jpa.dto;

import com.example.jpa.entities.Passport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    Integer id;
    String name;
    Passport passport;
}
