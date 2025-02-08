public class ForLoopExample {
    public static void main(String[] args)  throws Exception {
        looping();
    }

    /**
     * This method  will loop till 5 and return the output 
     * and if i is 2 don't print
     * 
     * @param 
     * @return integer
     * @exception Exception
     */
	private static Integer looping() throws Exception {
		Integer sum = 0;
		for (int i = 1; i <= 5; i++) {
        	if(i==2) {
        		continue;
        	}
        	sum +=i;
        }
		return sum;
	}
    
    

}