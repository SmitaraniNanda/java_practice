import java.util.Scanner;

public class DivisionCalculator {
    public static void main(String[] args) {
        

        System.out.print("Enter first number: ");
        

        System.out.print("Enter second number: ");
       
        try {
            double result = 10 / 0; //number divided by Zero
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }

        
    }
}
