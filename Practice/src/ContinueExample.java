/**
 * @author punya
 * @apiNote this is text
 */
public class ContinueExample {
	
	/**
	 * This is a main method which loop and print element
	 * 
	 * @param args
	 * @return 
	 * @throws 
	 * 
	 */
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.println("Skipping iteration at i = " + i);
                continue;
            }
            System.out.println("Iteration: " + i);
        }
    }
    
   /**
	 * This is a main method which loop and print element
	 * 
	 * @param args
	 * @return 
	 * @throws 
	 * 
	 */
    @Deprecated
    public int add() {
    	return 1;
    }
}