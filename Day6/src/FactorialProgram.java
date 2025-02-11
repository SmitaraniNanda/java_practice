/**
	     * Recursively calculates the factorial of a given number.
	     * 
	     * @param number The number for which the factorial is to be calculated.
	     * @return The factorial of the given number.
	     */
public class FactorialProgram {
	    
	    public static long calculateFactorial(int number) {
	        // If the number is 0 or 1, return 1
	        if (number == 0 || number == 1) {
	            return 1;
	        }
	        //  number * factorial of (number - 1)
	        return number * calculateFactorial(number - 1);
	    }

	    public static void main(String[] args) {
	        int Number = 5; 
	        
	        // Calculating factorial using the recursive method
	        long factorialResult = calculateFactorial(Number);
	        
	        // Printing the result
	        System.out.println("Factorial of " + Number + " is: " + factorialResult);
	    }
	

}
