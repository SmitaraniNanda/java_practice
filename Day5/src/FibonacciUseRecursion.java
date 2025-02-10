
public class FibonacciUseRecursion {
	
	    /**
	     * Computes the nth Fibonacci number using recursion.
	     *
	     * @param position The position in the Fibonacci sequence (starting from 0).
	     * @return The Fibonacci number at the given position.
	     */
	    public static int computeFibonacci(int position) {
	        if (position < 0) {
	            throw new IllegalArgumentException("Position cannot be negative.");
	        }
	        if (position == 0) {
	            return 0;
	        }
	        if (position == 1) {
	            return 1;
	        }
	        return computeFibonacci(position - 1) + computeFibonacci(position - 2);
	    }

	    public static void main(String[] args) {
	        int inputPosition = 34;
	        System.out.println("Fibonacci number at position " + inputPosition + " is " + computeFibonacci(inputPosition));
	    }
	}

