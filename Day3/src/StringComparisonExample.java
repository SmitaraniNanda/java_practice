public class StringComparisonExample {
    public static void main(String[] args) {
        // String objects using literals
        String str1 = "Hello";
        String str2 = "Hello";

        // Compare using ==
        System.out.println("Comparing string literals using == : " + (str1 == str2)); // True same memory reference

        // Compare using equals()
        System.out.println("Comparing string literals using equals() : " + str1.equals(str2)); // True same content

        // String objects using new keyword
        String str3 = new String("Hello");
        String str4 = new String("Hello");

        // Compare using ==
        System.out.println("Comparing strings created with 'new' using == : " + (str3 == str4)); // False different memory references

        // Compare using equals()
        System.out.println("Comparing strings created with 'new' using equals() : " + str3.equals(str4)); // True same content
    }
}
