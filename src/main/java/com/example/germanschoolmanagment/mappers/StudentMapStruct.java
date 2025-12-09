package com.example.germanschoolmanagment.mappers;

import com.example.germanschoolmanagment.dtos.StudentListDto;
import com.example.germanschoolmanagment.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = "spring")
public interface StudentMapStruct extends StudentMapper {
    
    @Mapping(target = "fullName", expression = "java(student.getName() + \" \" + student.getLastName())")
    @Mapping(target = "year", expression = "java(student.getGraduationDate() != null ? student.getGraduationDate().getYear() : 0)")
    StudentListDto toStudentListDto(Student student);
}
