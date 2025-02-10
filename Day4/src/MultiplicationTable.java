import java.util.Scanner;

/**
 * This program generates a multiplication table for a user-specified number.
 * It prints the results up to 10 but:
 * - Stops if the product exceeds 50.
 * - Skips printing if the product is a multiple of 3.
 */
public class MultiplicationTable {
    
    /**
     * The main method prompts the user to enter a number and prints its multiplication table.
     * The loop stops if the product exceeds 50 and skips numbers that are multiples of 3.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in); // Scanner object for user input
        System.out.print("Enter a number: ");
        
        int baseNumber = inputScanner.nextInt(); // Store the user input
        inputScanner.close(); // Close the scanner to prevent resource leaks

        // Generate and print the multiplication table
        for (int multiplier = 1; multiplier <= 10; multiplier++) {
            int productResult = baseNumber * multiplier;
            
            if (productResult > 50) {
                break; // Stop the loop if the product exceeds 50
            }
            if (productResult % 3 == 0) {
                continue; // Skip printing if the product is a multiple of 3
            }
            
            System.out.println(baseNumber + " x " + multiplier + " = " + productResult);
        }
    }
}
