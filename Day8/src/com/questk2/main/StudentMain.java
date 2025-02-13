package com.questk2.main;

// Abstract class representing a generic Student
abstract class Student {
    protected String studentName;
    protected int studentID;

    /**
     * Constructor to initialize Student.
     *
     * @param studentName The name of the student.
     * @param studentID The unique ID of the student.
     */
    public Student(String studentName, int studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    /**
     * Abstract method to calculate the grade.
     * Subclasses must provide implementation.
     *
     * @return The calculated grade as a double.
     */
    public abstract double calculateGrade();

    /**
     * Displays student details.
     */
    public void displayStudentInfo() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID: " + studentID);
    }
}

// Concrete class representing an Undergraduate Student
class UndergraduateStudent extends Student {
    private double assignmentScore;
    private double examScore;

    /**
     * Constructor to initialize an UndergraduateStudent.
     *
     * @param studentName The name of the student.
     * @param studentID The unique ID of the student.
     * @param assignmentScore The score obtained in assignments.
     * @param examScore The score obtained in the final exam.
     */
    public UndergraduateStudent(String studentName, int studentID, double assignmentScore, double examScore) {
        super(studentName, studentID);
        this.assignmentScore = assignmentScore;
        this.examScore = examScore;
    }

    /**
     * Calculates the final grade based on assignment and exam scores.
     *
     * @return The final grade as a double.
     */
    @Override
    public double calculateGrade() {
        return (assignmentScore * 0.4) + (examScore * 0.6);
    }
}

// Main class to test the abstraction concept
public class StudentMain {
    public static void main(String[] args) {
        UndergraduateStudent student = new UndergraduateStudent("Smita", 101, 85.5, 90.0);
        student.displayStudentInfo();
        System.out.println("Final Grade: " + student.calculateGrade());
    }
}
