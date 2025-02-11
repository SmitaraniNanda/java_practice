
/**
		     * Recursively calculates the power of a number.
		     * 
		     * @param base The base number.
		     * @param exponent The exponent to which the base is raised.
		     * @return The result of base^exponent.
		     */
public class PowerCalculation {		    
		    
			// Function to calculate base raised to the power exponent
		static int power(int base, int exponent)
		{
			if (exponent == 0)
				return 1;
			else
				return base * power(base, exponent - 1);
		}

		public static void main(String[] args)
		{
			int base = 3;
			int exponent = 2;

			System.out.println(power(base, exponent));
		}
	}



	


