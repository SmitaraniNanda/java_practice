
public class DigitPrograms {
	
	    /**
	     * Computes the sum of the digits of a given non-negative integer.
	     *
	     * @param number The non-negative integer whose digits' sum is to be calculated.
	     * @return The sum of the digits of the given number.
	     */
	    public static int computeSumOfDigits(int number) {
	        if (number < 0) {
	            throw new IllegalArgumentException("Number cannot be negative.");
	        }
	        
	        int sum = 0;
	        while (number > 0) {
	            sum += number % 10;
	            number /= 10;
	        }
	        return sum;
	    }

	    public static void main(String[] args) {
	        int inputNumber = 12345;
	        System.out.println("Sum of digits of " + inputNumber + " is " + computeSumOfDigits(inputNumber));
	    }
	}


