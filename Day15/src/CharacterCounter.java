import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharacterCounter {

    /**
     * Counts the number of occurrences of a specific character in a given file.
     *
     * @param filePath   The path of the file to be read.
     * @param targetChar The character whose occurrences need to be counted.
     * @return The count of occurrences of the target character.
     */
    public static int countCharacterOccurrences(String filePath, char targetChar) {
        int characterCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int currentCharacter;
            while ((currentCharacter = reader.read()) != -1) {
                if ((char) currentCharacter == targetChar) {
                    characterCount++;
                }
            }
        } catch (IOException exception) {
            System.err.println("Error reading file: " + exception.getMessage());
        }
        return characterCount;
    }

    public static void main(String[] args) {
        String filePath = "example.txt";
        char characterToCount = 'a';
        
        int occurrenceCount = countCharacterOccurrences(filePath, characterToCount);
        System.out.println("Character '" + characterToCount + "' appears " + occurrenceCount + " times.");
    }
}
