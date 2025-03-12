package com.questk2.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    // Field Injection
    @Autowired
    private Student student;

    // Constructor Injection
    private final String schoolName;

    @Autowired
    public StudentService(String schoolName) {
        this.schoolName = schoolName;
    }

    // Setter Injection
    private String courseName;

    @Autowired
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void displayStudentDetails() {
        System.out.println("Student Name: " + student.getName());
        System.out.println("School Name: " + schoolName);
        System.out.println("Course Name: " + courseName);
    }
}
