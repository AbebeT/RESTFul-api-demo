package com.example.jpa.dto;

import com.example.jpa.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PassportDto {
    String passportNumber;
    Person person;
}
