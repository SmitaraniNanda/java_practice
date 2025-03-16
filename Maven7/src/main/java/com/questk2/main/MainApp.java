package com.questk2.main;

import com.questk2.config.AppConfig;
import com.questk2.dao.StudentDAO;
import com.questk2.model.Student;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDAO studentDAO = context.getBean(StudentDAO.class);

        // Insert Student
        Student student1 = new Student(0, "Puspa", 22, "puspa@example.com");
        studentDAO.insertStudent(student1);

        // Update Student
        student1.setName("Smita");
        student1.setEmail("smita@example.com");
        studentDAO.updateStudent(student1);

        // Retrieve and Display Students
        List<Student> students = studentDAO.getAllStudents();
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
