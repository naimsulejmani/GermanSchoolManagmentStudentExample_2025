package com.example.germanschoolmanagment.mappers;

import com.example.germanschoolmanagment.dtos.StudentDto;
import com.example.germanschoolmanagment.dtos.StudentListDto;
import com.example.germanschoolmanagment.entities.Student;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student, StudentDto>{
    StudentListDto toStudentListDto(Student student);
    List<StudentListDto> toStudentListDtoList(List<Student> students);
}
