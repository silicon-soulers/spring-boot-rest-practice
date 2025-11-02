package com.rest_practice.rest_practice.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    // list all the students
    @GetMapping("/students")
    public List<StudentResponseDto> findAll() {
        return studentService.findAll();
    }

    // find the student by Id otherwise null student
    @GetMapping("/students/{student_id}")
    public StudentResponseDto findOne(@PathVariable("student_id") Integer id) {
        return studentService.findOne(id);
    }

    // find the students by their first name alike
    @GetMapping("/students/search/{first_name}")
    public List<StudentResponseDto> findByName(@PathVariable("first_name") String firstName) {
        return studentService.findByName(firstName);
    }

    @GetMapping("/students/search-age-greater/{age}")
    public List<StudentResponseDto> findAllByAgeGreaterThan(@PathVariable("age") Integer age) {
        return studentService.findAllByAgeGreaterThan(age);
    }


    // get the list of students with the age range
    // use the request parameters
    @GetMapping("/students/search-age-between")
    public List<StudentResponseDto> findAllByAgeBetween(@RequestParam("age1") Integer start, @RequestParam("age2") Integer end) {
        return studentService.findAllByAgeBetween(start, end);
    }
    // post a student or persist a student into the database
    @PostMapping("/students")
    public StudentResponseDto save(@Valid @RequestBody StudentDto dto) {
        return studentService.save(dto);
    }


    // deletion
    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("student-id") Integer id) {
        studentService.deleteById(id);
    }

    @DeleteMapping("/students")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        studentService.deleteAll();
    }

    @PutMapping("/students/{student-id}")
    public Student update(@PathVariable("student-id") Integer id, @RequestBody Student updatedStudent) {
        return studentService.update(id, updatedStudent);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException (MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String> ();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
