package com.questk2.dao;



import com.questk2.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   
    public void insertStudent(Student student) {
        String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getEmail());
        System.out.println("Student inserted successfully!");
    }

   
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, age=?, email=? WHERE id=?";
        jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getEmail(), student.getId());
        System.out.println("Student updated successfully!");
    }

    
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new RowMapper<Student>() {
           
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                );
            }
        });
    }
}

