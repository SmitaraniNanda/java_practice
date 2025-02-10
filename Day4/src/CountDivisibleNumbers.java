import java.util.Scanner;

/**
 * This program takes a user-input number (maxNumber) and prints numbers from 1 to maxNumber
 * that are divisible by both 2 and 3, while excluding numbers that are multiples of 5.
 * It also counts and displays the total number of such numbers.
 */
public class CountDivisibleNumbers {
    
    /**
     * The main method prompts the user for a number, processes the range from 1 to maxNumber,
     * prints numbers meeting the criteria, and displays the total count.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in); // Scanner object for user input
        System.out.print("Enter a number: ");
        
        int maxNumber = inputScanner.nextInt(); // Store the input value
        inputScanner.close(); // Close the scanner to prevent resource leaks
        
        System.out.println("Numbers divisible by both 2 and 3 (excluding multiples of 5):");
        int validNumberCount = 0; // Counter for valid numbers
        
        for (int currentNumber = 1; currentNumber <= maxNumber; currentNumber++) {
            if (currentNumber % 5 == 0) {
                continue; // Skip numbers divisible by 5
            }
            if (currentNumber % 2 == 0 && currentNumber % 3 == 0) {
                System.out.println(currentNumber);
                validNumberCount++;
            }
        }
        
        System.out.println("Total count: " + validNumberCount);
    }
}
