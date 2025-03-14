package com.questk2.service;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.questk2.model.Student;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return Arrays.asList(
            new Student("Smita", 22),
            new Student("Puspa", 23),
            new Student("Mamali", 21)
        );
    }
}
