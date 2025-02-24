import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderUsingBufferedReader {

    /**
     * Reads a file line by line and prints its content to the console.
     *
     * @param filePath The path of the file to be read.
     */
    public static void printFileContents(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "example.txt";
        printFileContents(fileName);
    }
}
