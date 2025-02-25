// Java Program to Illustrate File InputStream and File

// Importing required classes
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Main class
class FileCopy {

	// Main driver method
	public static void main(String[] args)
	{

		// Creating object of File class
		// Passing files from directory of local machine
		File sourcefile = new File("D:\\file.txt");
		File destinationfile = new File("D:\\output.txt");

		// Now creating object of FileInputStream
		// Here they are variables
		FileInputStream inputfile = null;
		FileOutputStream outputfile = null;

		try {
			// Now we make them as objects of both classes
			// and passed reference of file in directory
			inputfile = new FileInputStream(sourcefile);
			outputfile = new FileOutputStream(destinationfile);
		}

		// Catch block to handle exceptions
		catch (FileNotFoundException e) {

			// Display message if exception occurs
			// File Not Found or Path is Incorrect
			System.out.println("This is exception");
		}

		try {

			// Now let us check how many bytes are available
			// inside content of file
			inputfile.available();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		// Using while loop to
		// write over outputdemo file
		int count = 0;
		try {
			while ((count = inputfile.read()) != -1) {
				outputfile.write(count);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// It will execute no matter what
		// to close connections which is
		// always good practice
		

			// Closing the file connections

			// For input stream
			if (inputfile != null) {
				try {
					inputfile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// For output stream
			if (outputfile != null) {
				try {
					outputfile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
}
