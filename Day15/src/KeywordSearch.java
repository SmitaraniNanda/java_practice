// Java Program to Illustrate reading from
// FileReader using FileReader class

// Importing input output classes
import java.io.*;

// Main class
// ReadingFromFile
public class KeywordSearch {

    // Main driver method
    public static void main(String[] args) throws Exception
    {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the Path : ");
        
        // Reading File name
        String path = buffer.readLine();

        FileReader reader = new FileReader(path);

        // Declaring loop variable
        int bytedata;
      
        // Holds true till there is nothing to read
        while ((bytedata = reader.read()) != -1)

            // Print all the content of a file
            System.out.print((char)bytedata);
    }
}

