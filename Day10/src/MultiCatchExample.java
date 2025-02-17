	import java.util.Scanner;

	public class MultiCatchExample {
	    public static void main(String[] args) {
	        int[] numbers = {10, 20, 30, 40, 50}; // Array of 5 numbers
	        Scanner scanner = new Scanner(System.in);

	        try {
	            // Asking the user for an index
	            System.out.print("Enter an index (0-4) to retrieve a number: ");
	            int index = Integer.parseInt(scanner.nextLine()); // May throw NumberFormatException

	            // Retrieving the number from the array
	            System.out.println("Number at index " + index + ": " + numbers[index]); // May throw ArrayIndexOutOfBoundsException

	        } catch (ArrayIndexOutOfBoundsException e) {
	            System.out.println("Error: Index out of bounds! Please enter an index between 0 and 4.");
	        } catch (NumberFormatException e) {
	            System.out.println("Error: Invalid input! Please enter a numeric value.");
	        } finally {
	            scanner.close(); // Close scanner to prevent resource leak
	        }
	    }
	}


