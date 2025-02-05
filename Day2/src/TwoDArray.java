import java.util.Arrays;

class TwoDArray {
    public static void main(String[] args) {
        // Declare, create, and initialize a 2D array in a single statement
        int[][] iaa2 = { {3, 4}, {5, 6} };  // 2 rows, each with 2 elements
        
        // Print the number of rows and the number of elements in each row
        System.out.println("Number of rows: " + iaa2.length);  // 2
        System.out.println("Number of elements in row 0: " + iaa2[0].length);  // 2
        System.out.println("Number of elements in row 1: " + iaa2[1].length);  // 2
        System.out.println();

        // Loop through the array and print each element
        System.out.println("Elements of the 2D array:");
        for (int i = 0; i < iaa2.length; i++) {  // Loop through each row
            for (int j = 0; j < iaa2[i].length; j++) {  // Loop through each element in the row
                System.out.print(iaa2[i][j] + " ");  // Print the element
            }
            System.out.println();  // Move to the next line after printing a row
        }
        System.out.println();
    }
}
