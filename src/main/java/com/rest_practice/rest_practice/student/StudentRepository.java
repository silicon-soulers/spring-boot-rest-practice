package com.rest_practice.rest_practice.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // query methods for searching by name
    List<Student> findAllByFirstNameContainingIgnoreCase(String firstName);

    // query methods for searching by age
    List<Student> findAllByAgeGreaterThan(int age);
    List<Student> findAllByAgeLessThan(int age);

    List<Student> findAllByAgeBetween(int start, int end);
}
