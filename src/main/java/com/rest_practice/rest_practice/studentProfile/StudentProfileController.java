package com.rest_practice.rest_practice.studentProfile;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentProfileController {

    private final StudentProfileRepository studentProfileRepository;
    public StudentProfileController(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @PostMapping("/profiles")
    public StudentProfile create(@RequestBody StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    @GetMapping("/profiles")
    public List<StudentProfile> findAll() {
        return  studentProfileRepository.findAll();
    }

    @GetMapping("/profiles/{profile_id}")
    public StudentProfile findOne(@PathVariable int profile_id) {
        return studentProfileRepository.findById(profile_id).orElse(null);
    }
}
