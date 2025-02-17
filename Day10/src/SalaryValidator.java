
// Custom Exception for Invalid Salary
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

public class SalaryValidator {

    /**
     * Sets the salary for an employee.
     * @param salary The salary to be set.
     * @throws InvalidSalaryException if salary is less than 3500.
     */
    public static void setSalary(double salary) throws InvalidSalaryException {
        if (salary < 2000) {
            throw new InvalidSalaryException("Salary is too low! Minimum salary is 2000.");
        } else {
            System.out.println("Salary set successfully: $" + salary);
        }
    }

    public static void main(String[] args) {
        double salary = 2500; // Example salary

        try {
            setSalary(salary);
        } catch (InvalidSalaryException e) {
            System.out.println(e.getMessage());
        }
        
        salary = 3500; // Example valid salary

        try {
            setSalary(salary);
        } catch (InvalidSalaryException e) {
            System.out.println(e.getMessage());
        }
    }
}
