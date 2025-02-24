import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    /**
     * Copies the contents of a source file to a destination file.
     *
     * @param sourceFilePath      The path of the source file to be copied.
     * @param destinationFilePath The path of the destination file where the content will be copied.
     */
    public static void copyFile(String sourceFilePath, String destinationFilePath) {
        try (FileInputStream inputStream = new FileInputStream(sourceFilePath);
             FileOutputStream outputStream = new FileOutputStream(destinationFilePath)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            // Read from the source file and write to the destination file
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        copyFile("source.txt", "destination.txt");
    }
}
