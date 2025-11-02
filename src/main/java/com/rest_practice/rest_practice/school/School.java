package com.rest_practice.rest_practice.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rest_practice.rest_practice.student.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Integer schoolId;

    private String schoolName;
    
    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Student> students;
    public School() {}

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getSchoolId() { return schoolId; }
    public String getSchoolName() { return schoolName; }
    public void setSchoolId(Integer schoolId) { this.schoolId = schoolId; }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
