package com.example.germanschoolmanagment.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @PositiveOrZero(message = "Id must be positive or zero!")
    private long id;


    @NotNull(message = "Name must not be null!")
    @NotBlank(message = "Name must not be empty or blank!")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters!")
    private String name;

    @NotNull(message = "LastName must not be null!")
    @NotBlank(message = "LastName must not be empty or blank!")
    @Size(min = 2, max = 50, message = "LastName must be between 2 and 50 characters!")
    private String lastName;


    @Pattern(message = "Phone number must be in the format of +XXXYYZZZZZZ", regexp = "^\\+\\d{11}$")
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    @Pattern(message = "Gender must be M or F!", regexp = "^[MF]$")
    private String gender;

    @Past(message = "Date of birth must be in the past!")
//    @MinAge(value = 16, message = "Date of birth must be at least 16 years old!")
    private LocalDate dateOfBirth;
    @Email(message = "Email must be valid!")
    private String email;

    @NotNull(message = "Password must not be null!")
    @NotBlank(message = "Password must not be empty or blank!")
    // should have at least one uppercase letter, one lowercase letter, one digit and one special character
    @Pattern(message = "Password must have at least one uppercase letter, one lowercase letter, one digit and one special character!",
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters!")
    private String password;

//    @ConfirmPassword(message = "Passwords do not match!")
//    private String confirmPassword;

    private boolean active = true;

    @NotNull(message = "Registration date must not be null!")
    private LocalDate registrationDate = LocalDate.now();

    @FutureOrPresent(message = "Graduation date must be in the future or present!")
    private LocalDate graduationDate;

    @Size(max = 1000, message = "Image URL must be between 0 and 1000 characters!")
    private String imageUrl;
}
