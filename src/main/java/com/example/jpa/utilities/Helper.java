package com.example.jpa.utilities;

import com.example.jpa.entities.Passport;
import com.example.jpa.dto.PassportDto;

public class Helper {
   public static PassportDto toDto(Passport passport){
      return PassportDto.builder()
              .passportNumber(passport.getPassportNumber())
              .person(passport.getPerson())
              .build();
   }
   public static Passport toEntity(PassportDto passport){
      return Passport.builder()
              .passportNumber(passport.getPassportNumber())
              .person(passport.getPerson())
              .build();
   }
}
