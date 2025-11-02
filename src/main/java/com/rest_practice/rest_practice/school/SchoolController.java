package com.rest_practice.rest_practice.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;
    public SchoolController(SchoolRepository schoolRepository, SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto dto) {
        return schoolService.create(dto);
    }


    @GetMapping("/schools")
    public List<SchoolDto> findAll() {
        return schoolService.findAll();
    }

    @GetMapping("/schools/{school_id}")
    public SchoolDto findOne(@PathVariable("school_id") Integer schoolId) {
        return schoolService.findOne(schoolId);
    }
}
