import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharacterCounter {
    public static int countCharacterOccurrences(String filePath, char targetChar) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                if ((char) ch == targetChar) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String filePath = "D:\\file.txt";  // Replace with your actual file path
        char targetChar = 'i';  // Replace with the character you want to count

        int occurrences = countCharacterOccurrences(filePath, targetChar);
        System.out.println("Character '" + targetChar + "' appears " + occurrences + " times in the file.");
    }
}
