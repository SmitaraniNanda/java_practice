import java.util.Scanner;

/**
 * This program generates the Fibonacci sequence up to a user-specified number (maxLimit).
 * It assigns superhero names based on divisibility rules:
 * - Numbers divisible by both 3 and 5: "I am Spiderman and Ironman"
 * - Numbers divisible by 3: "I am Spiderman"
 * - Numbers divisible by 5: "I am Ironman"
 * - Other numbers: "I am Zero"
 */
public class FibonacciSuperhero {
    
    /**
     * The main method prompts the user for an upper limit, generates the Fibonacci sequence up to that limit, 
     * and assigns superhero names based on divisibility rules.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in); // Scanner object for user input
        System.out.print("Enter a number N: ");
        
        int maxLimit = inputScanner.nextInt(); // Store the user input
        inputScanner.close(); // Close the scanner to prevent resource leaks
        
        int firstTerm = 0, secondTerm = 1; // Initialize Fibonacci sequence
        
        System.out.println("Fibonacci sequence up to " + maxLimit + ":");
        for (int index = 0; firstTerm <= maxLimit; index++) {
            // Assign superhero names based on divisibility conditions
            if (firstTerm % 3 == 0 && firstTerm % 5 == 0) {
                System.out.println(firstTerm + " - I am Spiderman and Ironman");
            } else if (firstTerm % 3 == 0) {
                System.out.println(firstTerm + " - I am Spiderman");
            } else if (firstTerm % 5 == 0) {
                System.out.println(firstTerm + " - I am Ironman");
            } else {
                System.out.println(firstTerm + " - I am Zero");
            }
            
            // Generate the next Fibonacci number
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }
}
