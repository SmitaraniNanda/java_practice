

/**
 * This program calculates the sum of all elements in an integer array.
 */
public class SumOfAnArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4}; // Array of integers
        long sum = 0L; // Variable to store the sum of array elements

        // Loop through the array and add each element to the sum
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        // Print the final sum
        System.out.println("Sum of array elements: " + sum);
    }
}
