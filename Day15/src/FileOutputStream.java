import java.io.FileInputStream;
import java.io.IOException;

public class FileOutputStream {
    public static void readFile(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readFile("example.txt");
    }
}
