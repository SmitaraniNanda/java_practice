import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

	public class FileOutputStream {

		public static void main(String[] args) {	 
			
				
				try {
					
					// Creating file object and specifying path
					File file = new File("D:\\file.txt");

					FileInputStream input= new FileInputStream(file);
					int character;
					// read character by character by default
					// read() function return int between 0 and 255.

					while ((character = input.read()) != -1) {
						System.out.print((char)character);
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
		}

		public void write(int byteData) {
			
		}

		
	

}
