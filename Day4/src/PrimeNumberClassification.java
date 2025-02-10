import java.util.Scanner;

/**
 * This program generates a specified number of prime numbers and classifies them based on their value:
 *  "Small" for numbers less than 10
 *  "Medium" for numbers between 10 and 49
 *  "Large" for numbers 50 and above
 */
public class PrimeNumberClassification {
    
    /**
     * The main method prompts the user to enter the number of prime numbers to generate.
     * It then finds and classifies the prime numbers accordingly.
     * 
     * @param args Command-line arguments 
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in); // Scanner object for user input
        System.out.print("Enter the number of prime numbers to generate: ");
        
        int primeCountLimit = inputScanner.nextInt(); // Number of primes to generate
        inputScanner.close(); // Close the scanner to prevent resource leaks

        int generatedPrimeCount = 0; // Counter for found primes
        int currentNumber = 2; // Start checking from the first prime number

        while (generatedPrimeCount < primeCountLimit) {
            if (isPrime(currentNumber)) {
                classifyPrime(currentNumber); // Classify and print the prime number
                generatedPrimeCount++;
            }
            currentNumber++;
        }
    }

    /**
     * Checks if a given number is prime.
     * 
     * @param number The number to check
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) return false;
        }
        return true;
    }

    /**
     * Classifies a prime number based on its value and prints its classification.
     * 
     * @param primeNumber The prime number to classify
     */
    public static void classifyPrime(int primeNumber) {
        String classification;
        
        if (primeNumber < 10) {
            classification = "Small";
        } else if (primeNumber < 50) {
            classification = "Medium";
        } else {
            classification = "Large";
        }

        System.out.println(primeNumber + " is " + classification);
    }
}
