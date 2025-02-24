import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KeywordSearch {
    public static void searchKeyword(String filePath, String keyword) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                if (line.contains(keyword)) {
                    System.out.println("Keyword found in line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        searchKeyword("example.txt", "hello");
    }
}
