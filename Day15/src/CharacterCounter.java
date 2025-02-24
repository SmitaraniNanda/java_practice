import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharacterCounter {
    public static int countCharacterOccurrences(String filePath, char targetChar) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int c;
            while ((c = br.read()) != -1) {
                if ((char) c == targetChar) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        int occurrences = countCharacterOccurrences("example.txt", 'a');
        System.out.println("Character 'a' appears " + occurrences + " times.");
    }
}
