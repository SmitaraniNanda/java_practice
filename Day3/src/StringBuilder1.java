
import java.util.Scanner;

public class StringBuilder1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking string input from the user
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        
        // Reversing the string using StringBuilder
        StringBuilder sb = new StringBuilder(userInput);
        String reversedString = sb.reverse().toString();
        
        // Checking if the string is a palindrome
        boolean isPalindrome = userInput.equalsIgnoreCase(reversedString);
        
        // Displaying results
        System.out.println("\nOriginal String: " + userInput);
        System.out.println("Reversed String: " + reversedString);
        System.out.println("Is Palindrome: " + isPalindrome);
        
        scanner.close();
    }
}