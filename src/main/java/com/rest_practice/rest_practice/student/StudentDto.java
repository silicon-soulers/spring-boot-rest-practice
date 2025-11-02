package com.rest_practice.rest_practice.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "FirstName cannot be empty")
        String firstName,
        @NotEmpty(message = "LastName cannot be empty")
        String lastName,
        String email,
        Integer schoolId) {
}
