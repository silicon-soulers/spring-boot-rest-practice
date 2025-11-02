package com.rest_practice.rest_practice.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDto dto) {
        return new School(dto.schoolName());
    }

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getSchoolName());
    }
}
