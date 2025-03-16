package com.questk2.dao;


import com.questk2.model.Student;
import java.util.List;

public interface StudentDAO {
    void insertStudent(Student student);
    void updateStudent(Student student);
    List<Student> getAllStudents();
}
