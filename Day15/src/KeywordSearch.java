import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KeywordSearch {
    
    /**
     * Searches for a specific keyword in a given file and prints the lines where the keyword is found.
     * 
     * @param filePath The path to the file to be searched.
     * @param keyword  The keyword to search for within the file.
     */
    public static void searchKeywordInFile(String filePath, String keyword) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            int lineNumber = 1;
            
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(keyword)) {
                    System.out.println("Keyword found in line " + lineNumber + ": " + currentLine);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        searchKeywordInFile("example.txt", "hello");
    }
}
