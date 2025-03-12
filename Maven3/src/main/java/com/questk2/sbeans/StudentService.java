package com.questk2.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class StudentService {
    
    // Field Injection
    @Autowired
    private Student student;

    // Constructor Injection using @Value
    private final String schoolName;

    @Autowired
    public StudentService(@Value("QuestK2 School") String schoolName) {
        this.schoolName = schoolName;
    }

    // Setter Injection using @Value
    private String courseName;

    @Autowired
    public void setCourseName(@Value("Spring Framework") String courseName) {
        this.courseName = courseName;
    }

    @PostConstruct
    public void init() {
        System.out.println("StudentService Bean: @PostConstruct Called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("StudentService Bean: @PreDestroy (Cleanup) Called");
    }

    public void displayStudentDetails() {
        System.out.println("Student Name: " + student.getName());
        System.out.println("School Name: " + schoolName);
        System.out.println("Course Name: " + courseName);
    }
}
