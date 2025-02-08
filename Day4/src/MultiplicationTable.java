import java.util.Scanner;

public class MultiplicationTable {
    /**
     * This is a main method which loops and prints elements.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= 10; i++) {
            int product = number * i;
            
            if (product > 50) {
                break; // Stop the loop if the product exceeds 50
            }
            if (product % 3 == 0) {
                continue; // Skip printing if the product is a multiple of 3
            }
            
            System.out.println(number + " x " + i + " = " + product);
        }
    }
}
