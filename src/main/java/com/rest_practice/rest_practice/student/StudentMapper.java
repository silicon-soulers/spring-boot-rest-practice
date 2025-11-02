package com.rest_practice.rest_practice.student;

import com.rest_practice.rest_practice.school.School;
import com.rest_practice.rest_practice.school.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {


    public Student toStudent(StudentDto dto){
        if (dto == null) {
            throw new NullPointerException("Dto cannot be null");
        }
        Student student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        School school = new School();
        school.setSchoolId(dto.schoolId());
        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentDto(Student student){
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getSchool().getSchoolName()
        );
    }

}
