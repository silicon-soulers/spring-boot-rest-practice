package com.rest_practice.rest_practice.student;

public record StudentResponseDto(
        String firstName,
        String lastName,
        String email,
        String schoolName
) {
}
