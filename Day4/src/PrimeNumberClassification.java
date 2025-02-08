import java.util.Scanner;

public class PrimeNumberClassification {
    /**
     * This is a main method that generates and classifies prime numbers.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of prime numbers to generate: ");
        int n = scanner.nextInt();
        scanner.close();

        int count = 0, num = 2;
        while (count < n) {
            if (isPrime(num)) {
                classifyPrime(num);
                count++;
            }
            num++;
        }
    }

    /**
     * Method to check if a number is prime.
     * 
     * @param num The number to check
     * @return true if prime, false otherwise
     */
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * Method to classify a prime number.
     * 
     * @param num The prime number to classify
     */
    public static void classifyPrime(int num) {
        String classification;
        
        switch (num / 10) {
            case 0:
                classification = "Small";
                break;
            case 1: case 2: case 3: case 4:
                classification = "Medium";
                break;
            default:
                classification = "Large";
        }
        
        System.out.println(num + " is " + classification);
    }
}