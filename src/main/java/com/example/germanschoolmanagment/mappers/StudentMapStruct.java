package com.example.germanschoolmanagment.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Mapper(componentModel = "spring")
public interface StudentMapStruct extends StudentMapper {
//    StudentMapStruct INSTANCE = Mappers.getMapper(StudentMapStruct.class);
}
