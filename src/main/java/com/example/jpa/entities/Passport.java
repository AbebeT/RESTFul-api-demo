package com.example.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="passport")
@JsonIgnoreProperties("id")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "passport_number")
    String passportNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @JsonIgnore
    Person person;
}
