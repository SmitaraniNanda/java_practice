
public class PrimeCheckFunction {
	
	    /**
	     * Checks whether a given number is a prime number.
	     *
	     * @param number The integer to check for primary.
	     * @return true if the number is prime, false otherwise.
	     */
	    public static boolean isPrime(int number) {
	        if (number <= 1) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(number); i++) {
	            if (number % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        int inputNumber = 38;
	        if (isPrime(inputNumber)) {
	            System.out.println(inputNumber + " is a prime number.");
	        } else {
	            System.out.println(inputNumber + " is not a prime number.");
	        }
	    }
	}


