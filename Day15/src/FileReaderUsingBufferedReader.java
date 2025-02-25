// Java program to illustrate 
// BufferedReader read() method 

import java.io.*; 

public class FileReaderUsingBufferedReader { 
	public static void main(String[] args) { 
try {
		// Read the stream 'demo.txt' 
		// containing text "GEEKSFORGEEKS" 
		FileReader fileReader = new FileReader( "D:\\file.txt"); 

		// Convert fileReader to 
		// bufferedReader 
		BufferedReader buffReader = new BufferedReader(fileReader); 

		while (buffReader.ready()) { 
			// Read and print characters one by one 
			// by converting into character 
			System.out.println("Char :" + (char)buffReader.read()); 
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	} 
} 
