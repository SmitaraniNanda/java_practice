
public class PallindromeCheck {
	    
	    /**
	     * Recursively checks if a given string is a palindrome.
	     * 
	     * @param inputString The string to check.
	     * @param left The starting index (initially 0).
	     * @param right The ending index (initially inputString.length() - 1).
	     * @return true if the string is a palindrome, false otherwise.
	     */
	    public static boolean isPalindrome(String inputString, int left, int right) {
	        // If the left index is greater than or equal to the right index, it's a palindrome
	        if (left >= right) {
	            return true;
	        }
	        
	        // If characters at the current indices do not match, it's not a palindrome
	        if (inputString.charAt(left) != inputString.charAt(right)) {
	            return false;
	        }
	        
	        // Recursive call with the next inner pair of characters
	        return isPalindrome(inputString, left + 1, right - 1);
	    }

	    public static void main(String[] args) {
	        String testString = "madam";
	        
	        // Checking if the test string is a palindrome
	        boolean result = isPalindrome(testString, 0, testString.length() - 1);
	        
	        // Printing the result
	        if (result) {
	            System.out.println(testString + " is a palindrome.");
	        } else {
	            System.out.println(testString + " is not a palindrome.");
	        }
	    }
	
}
