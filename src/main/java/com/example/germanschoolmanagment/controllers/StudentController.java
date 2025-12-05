package com.example.germanschoolmanagment.controllers;

import com.example.germanschoolmanagment.dtos.StudentDto;
import com.example.germanschoolmanagment.services.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    @GetMapping("/new")
    public String getStudentForm(Model model) {
        model.addAttribute("student", new StudentDto());
        return "student/new";
    }

    @PostMapping("/new")
    public String createStudent(@Valid @ModelAttribute("student") StudentDto studentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student/new";
        }
        studentService.add(studentDto);
        return "redirect:/students";
    }
}
