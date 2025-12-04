package com.example.germanschoolmanagment.services;

import com.example.germanschoolmanagment.dtos.StudentDto;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();
    StudentDto findById(Long id);
    StudentDto add(StudentDto studentDto);
    StudentDto update(Long id, StudentDto studentDto);
    void delete(Long id);
    List<StudentDto> findAllByRegistrationDateGreaterThan(LocalDate date);
    List<StudentDto> findAllByActiveOrderByRegistrationDateDesc(boolean active);
    Long countAllByActive(boolean active);
    boolean changeActive(Long id);
}
