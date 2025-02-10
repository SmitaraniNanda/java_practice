import java.util.Scanner;

/**
 * This program prints a pattern based on the number of rows entered by the user.
 * - For odd-numbered rows, it prints asterisks (*).
 * - For even-numbered rows, it prints the row number.
 */
public class PatternProgram {
    
    /**
     * The main method prompts the user to enter the number of rows for the pattern,
     * then generates and prints the pattern based on the specified conditions.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in); // Scanner object for user input
        System.out.print("Enter the number of rows: ");
        
        int totalRows = inputScanner.nextInt(); // Store the user input
        inputScanner.close(); // Close the scanner to prevent resource leaks

        // Generate and print the pattern
        for (int currentRow = 1; currentRow <= totalRows; currentRow++) {
            for (int column = 1; column <= currentRow; column++) {
                if (currentRow % 2 == 0) {
                    System.out.print(currentRow); // Print row number for even rows
                } else {
                    System.out.print("*"); // Print '*' for odd rows
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
