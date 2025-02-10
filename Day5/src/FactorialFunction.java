import java.util.Scanner;
public class FactorialFunction {
	    /**
	     * Calculates the factorial of a given non-negative integer.
	     *
	     * @param number A non-negative integer whose factorial is to be computed.
	     * @return Factorial of the given number.
	     * @throws IllegalArgumentException if the input number is negative.
	     */
	    public static long calculateFactorial(int number) {
	        if (number < 0) {
	            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
	        }
	        
	        long factorialResult = 1;
	        for (int i = 1; i <= number; i++) {
	            factorialResult *= i;
	        }
	        
	        return factorialResult;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a non-negative integer: ");
	        int inputNumber = scanner.nextInt();
	        scanner.close();
	        
	        try {
	            long result = calculateFactorial(inputNumber);
	            System.out.println("Factorial of " + inputNumber + " is " + result);
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	
}

