import java.io.FileInputStream;
import java.io.IOException;

public class FileOutputStream {
    
    /**
     * Reads the contents of a file and prints it to the console.
     * 
     * @param filePath the path of the file to be read
     */
    public static void readFileContents(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            int character;
            while ((character = fileInputStream.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readFileContents("example.txt");
    }
}
