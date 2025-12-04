package com.example.germanschoolmanagment.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "phone_number", length = 15)
    private String phoneNumber;
    @Column(name = "address", length = 200)
    private String address;
    @Column(length = 50)
    private String city;
    @Column(length = 50)
    private String state;
    @Column(length = 10)
    private String zipCode;
    @Column(length = 50)
    private String country;
    @Column(length = 1)
    private String gender;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 100, nullable = false)
    private String password;
    private boolean active;
    @Column(nullable = false)
    private LocalDate registrationDate;
    private LocalDate graduationDate;
}
