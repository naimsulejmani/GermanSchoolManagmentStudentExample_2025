package com.example.germanschoolmanagment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentListDto {
    private long id;
    private String fullName;
    private String imageUrl;
    private int year;
}
