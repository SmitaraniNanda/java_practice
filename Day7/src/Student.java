public class Student {
    
    // Fields (Instance Variables)
    String name;
    int age;
    String studentId;
    
    /**
     * Constructor to initialize Student object.
     * @param name  name of the student.
     * @param age  age of the student.
     * @param studentId unique ID of the student.
     */
    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }
    
    
     //Displays the student's details.
     
    public void displayStudentDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentId);
    }
    
    // Main method to test the Student class
    public static void main(String[] args) {
        Student student = new Student("Smita", 22, "S12345");
        student.displayStudentDetails();
    }
}
