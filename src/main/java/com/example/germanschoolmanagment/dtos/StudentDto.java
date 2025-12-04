package com.example.germanschoolmanagment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String gender;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private boolean active;
    private LocalDate registrationDate;
    private LocalDate graduationDate;
}
