public class StringBufferExample {
    public static void main(String[] args) {
        // Create a StringBuffer object
        StringBuffer sb = new StringBuffer("Hello");
        
        // Append words to the string
        sb.append(" World");
        sb.append(" from Java");
        System.out.println("After Append: " + sb);
        
        // Insert a word at a specific position
        sb.insert(6, "Beautiful ");
        System.out.println("After Insert: " + sb);
        
        // Delete a word from the string
        sb.delete(6, 16); // Removing "Beautiful " (index 6 to 16)
        System.out.println("After Delete: " + sb);
    }
}
