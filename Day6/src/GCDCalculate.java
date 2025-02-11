
/**
	     * Computes the Greatest Common Divisor (GCD) of two numbers using recursion.
	     * 
	     * @param num1 The first number.
	     * @param num2 The second number.
	     * @return The GCD of num1 and num2.
	     */
public class GCDCalculate {
	    
	    public static int GCD(int num1, int num2) {
	        //  if the second number becomes zero, return the first number
	        if (num2 == 0) {
	            return num1;
	        }
	        //  call the method with num2 and remainder of num1/num2
	        return GCD(num2, num1 % num2);
	    }

	    public static void main(String[] args) {
	        int number1 = 48;
	        int number2 = 0;
	        
	        int gcd = GCD(number1, number2);
	        
	        System.out.println("The GCD of " + number1 + " and " + number2 + " is: " + gcd);
	    }
	

}
