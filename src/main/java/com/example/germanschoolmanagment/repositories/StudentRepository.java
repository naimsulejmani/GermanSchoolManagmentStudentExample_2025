package com.example.germanschoolmanagment.repositories;

import com.example.germanschoolmanagment.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByRegistrationDateGreaterThan(LocalDate date);
    List<Student> findAllByActiveOrderByRegistrationDateDesc(boolean active);
    Long countAllByActive(boolean active);
}
