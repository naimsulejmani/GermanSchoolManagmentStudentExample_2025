package com.example.germanschoolmanagment.services.impls;

import com.example.germanschoolmanagment.dtos.StudentDto;
import com.example.germanschoolmanagment.mappers.StudentMapper;
import com.example.germanschoolmanagment.repositories.StudentRepository;
import com.example.germanschoolmanagment.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> findAll() {
        var students = studentRepository.findAll();
        return studentMapper.toDtoList(students);
    }

    @Override
    public StudentDto findById(Long id) {
        var student = studentRepository.findById(id);
        if (student.isEmpty()) return null;
        return studentMapper.toDto(student.get());
    }

    @Override
    public StudentDto add(StudentDto studentDto) {
        var student = studentMapper.toEntity(studentDto);
        if (studentDto.getId() > 0) {
            if(studentRepository.existsById(studentDto.getId())) {
                throw new RuntimeException("Student already exists");
            }
        }
        studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDto update(Long id, StudentDto studentDto) {
        var studentExist = studentRepository.existsById(id);
        if (!studentExist) {
            throw new RuntimeException("Student not found");
        }
        var updatedStudent = studentMapper.toEntity(studentDto);
        studentRepository.save(updatedStudent);
        return studentMapper.toDto(updatedStudent);
    }

    @Override
    public void delete(Long id) {
        var studentExist = studentRepository.existsById(id);
        if (!studentExist) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDto> findAllByRegistrationDateGreaterThan(LocalDate date) {
        var students = studentRepository.findAllByRegistrationDateGreaterThan(date);
        return studentMapper.toDtoList(students);
    }

    @Override
    public List<StudentDto> findAllByActiveOrderByRegistrationDateDesc(boolean active) {
        var students = studentRepository.findAllByActiveOrderByRegistrationDateDesc(active);
        return studentMapper.toDtoList(students);
    }

    @Override
    public Long countAllByActive(boolean active) {
        return studentRepository.countAllByActive(active);
    }

    @Override
    public boolean changeActive(Long id) {
        var optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isEmpty()) return false;
        var student = optionalStudent.get();
        student.setActive(!student.isActive());
        studentRepository.save(student);
        return true;
    }
}
