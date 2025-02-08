import java.util.Scanner;

/**
 * This program takes a user input number (n) and prints numbers from 1 to n
 * that are divisible by both 2 and 3, while excluding numbers that are 
 * multiples of 5. It also counts and displays the total number of such numbers.
 */

public class CountDivisibleNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();
        
        System.out.println("Numbers divisible by both 2 and 3 (excluding multiples of 5):");
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                continue; // Skip numbers divisible by 5
            }
            if (i % 2 == 0 && i % 3 == 0) {
                System.out.println(i);
                count++;
            }
        }
        
        System.out.println("Total count: " + count);
    }
}