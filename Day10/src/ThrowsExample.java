

import java.io.IOException;

public class ThrowsExample {

    /**
     * Simulates reading a file (throws IOException).
     * @param fileName The name of the file to read.
     * @throws IOException if there is an error while reading the file.
     */
    public static void readFile(String fileName) throws IOException {
        // Simulating a file reading error
        System.out.println("Attempting to read file: " + fileName);
        throw new IOException("Error: File could not be read.");
    }

    public static void main(String[] args) {
        // Handling File Read Exception
        try {
            readFile("abc"); // Simulating file reading
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage()); // Handling IOException
        }
    }
}
