package com.example.germanschoolmanagment.controllers;

import com.example.germanschoolmanagment.dtos.StudentDto;
import com.example.germanschoolmanagment.services.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        model.addAttribute("maxDate",
                LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        model.addAttribute("minDate",
                LocalDate.now().minusYears(65).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return "student/new";
    }

    // @ModelAttribute("emri") => duhet me qene i njejte me model.addAttribute("emri", new StudentDto());
    @PostMapping("/new")
    public String createStudent(@Valid @ModelAttribute("student") StudentDto studentDto,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student/new";
        }
        studentService.add(studentDto);
        return "redirect:/students";
    }
}
