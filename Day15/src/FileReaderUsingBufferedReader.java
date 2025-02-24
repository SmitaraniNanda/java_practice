
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderUsingBufferedReader {
    public static void readFileLineByLine(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readFileLineByLine("example.txt");
    }
}

