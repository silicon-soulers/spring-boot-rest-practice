package com.rest_practice.rest_practice.studentProfile;

import com.rest_practice.rest_practice.student.Student;
import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer studentProfileId;

    private String bio;

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public StudentProfile() {}

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public String  getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getStudentProfileId() {
        return studentProfileId;
    }

    public void setStudentProfileId(Integer studentProfileId) {
        this.studentProfileId = studentProfileId;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
