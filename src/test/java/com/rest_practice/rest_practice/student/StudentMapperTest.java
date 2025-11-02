package com.rest_practice.rest_practice.student;

import com.rest_practice.rest_practice.school.School;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto(
                "Yin Min",
                "Aung",
                "yinminaung@gmail.com",
                1
        );

        Student student = studentMapper.toStudent(dto);

        Assertions.assertEquals(dto.firstName(), student.getFirstName());
        Assertions.assertEquals(dto.lastName(), student.getLastName());
        Assertions.assertEquals(dto.email(), student.getEmail());
        Assertions.assertNotNull(student.getSchool());
        Assertions.assertEquals(dto.schoolId(), student.getSchool().getSchoolId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_dto_is_null() {
        var msg = Assertions.assertThrows(NullPointerException.class,
                () ->  studentMapper.toStudent(null));
        Assertions.assertEquals("Dto cannot be null", msg.getMessage());
    }

    @Test
    public void shouldMapStudentToStudentDTO() {
        Student student = new Student();
        student.setFirstName("Yin Min");
        student.setLastName("Aung");
        student.setEmail("yinminaung@gmail.com");
        School school = new School();
        school.setSchoolName("Yin Academy");
        student.setSchool(school);
        StudentResponseDto dto = studentMapper.toStudentDto(student);

        Assertions.assertEquals(student.getFirstName(), dto.firstName());
        Assertions.assertEquals(student.getLastName(), dto.lastName());
        Assertions.assertEquals(student.getEmail(), dto.email());
        Assertions.assertEquals(student.getSchool().getSchoolName(), dto.schoolName());

    }



}