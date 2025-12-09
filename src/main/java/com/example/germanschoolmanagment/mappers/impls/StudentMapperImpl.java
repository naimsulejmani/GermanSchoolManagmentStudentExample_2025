package com.example.germanschoolmanagment.mappers.impls;

import com.example.germanschoolmanagment.dtos.StudentDto;
import com.example.germanschoolmanagment.dtos.StudentListDto;
import com.example.germanschoolmanagment.entities.Student;
import com.example.germanschoolmanagment.mappers.StudentMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDto toDto(Student entity) {
        if (entity == null) return null;
        StudentDto dto = new StudentDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLastName(entity.getLastName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZipCode(entity.getZipCode());
        dto.setCountry(entity.getCountry());
        dto.setGender(entity.getGender());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setActive(entity.isActive());
        dto.setRegistrationDate(entity.getRegistrationDate());
        dto.setGraduationDate(entity.getGraduationDate());
        dto.setImageUrl(entity.getImageUrl());

        return dto;
    }

    @Override
    public Student toEntity(StudentDto dto) {
        if (dto == null) return null;
        Student entity = new Student();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setZipCode(dto.getZipCode());
        entity.setCountry(dto.getCountry());
        entity.setGender(dto.getGender());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setActive(dto.isActive());
        entity.setRegistrationDate(dto.getRegistrationDate());
        entity.setGraduationDate(dto.getGraduationDate());
        entity.setImageUrl(dto.getImageUrl());

        return entity;
    }

    @Override
    public List<StudentDto> toDtoList(List<Student> entities) {
        if (entities == null || entities.isEmpty()) return List.of();
//        List<StudentDto> dtos = new ArrayList<>(entities.size());
//        for (Student s : entities) {
//            dtos.add(toDto(s));
//        }
//        return dtos;
        return entities.stream().map(this::toDto).toList();
    }

    @Override
    public List<Student> toEntityList(List<StudentDto> dtos) {
        if (dtos == null || dtos.isEmpty()) return List.of();
//        List<Student> entities = new ArrayList<>(dtos.size());
//        for (StudentDto d : dtos) {
//            entities.add(toEntity(d));
//        }
//        return entities;
        return dtos.stream().map(this::toEntity).toList();
    }

    @Override
    public StudentListDto toStudentListDto(Student student) {

        StudentListDto slDto = new StudentListDto();
        slDto.setId(student.getId());
        slDto.setFullName(student.getName() + " " + student.getLastName());
        slDto.setImageUrl(student.getImageUrl());
        slDto.setYear(student.getGraduationDate().getYear());

        return null;
    }

    @Override
    public List<StudentListDto> toStudentListDtoList(List<Student> students) {
        return students.stream().map(this::toStudentListDto).toList();
    }
}
