package com.rest_practice.rest_practice.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto save( StudentDto dto) {
        Student student = studentMapper.toStudent(dto);
        var saved = repository.save(student);
        return studentMapper.toStudentDto(saved);
    }

    public List<StudentResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto findOne(Integer id) {
        return repository.findById(id)
                .map(studentMapper::toStudentDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findByName(String firstName) {
        return repository.findAllByFirstNameContainingIgnoreCase(firstName)
                .stream()
                .map(studentMapper::toStudentDto)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDto> findAllByAgeGreaterThan(Integer age) {
        return repository.findAllByAgeGreaterThan(age)
                .stream()
                .map(studentMapper::toStudentDto)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDto> findAllByAgeBetween(Integer start, Integer end) {
        return repository.findAllByAgeBetween(start, end)
                .stream()
                .map(studentMapper::toStudentDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public Student update(Integer id,Student updatedStudent) {
        return repository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setFirstName(updatedStudent.getFirstName());
                    existingStudent.setLastName(updatedStudent.getLastName());
                    existingStudent.setEmail(updatedStudent.getEmail());
                    existingStudent.setAge(updatedStudent.getAge());
                    return repository.save(existingStudent);
                }).orElse(new Student());
    }

}
