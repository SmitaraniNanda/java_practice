
import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking string input from the user
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        
        // Converting to uppercase and lowercase
        String upperCase = userInput.toUpperCase();
        String lowerCase = userInput.toLowerCase();
        
        // Finding the length of the string
        int length = userInput.length();
        
        // Replacing occurrences of a specific character
        System.out.print("Enter the character to replace: ");
        char oldChar = scanner.next().charAt(0);
        System.out.print("Enter the new character: ");
        char newChar = scanner.next().charAt(0);
        
        String replacedString = userInput.replace(oldChar, newChar);
        
        // Displaying results
        System.out.println("\nOriginal String: " + userInput);
        System.out.println("Uppercase: " + upperCase);
        System.out.println("Lowercase: " + lowerCase);
        System.out.println("Length: " + length);
        System.out.println("Modified String: " + replacedString);
        
        scanner.close();
    }
}
