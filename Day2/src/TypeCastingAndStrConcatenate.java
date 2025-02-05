
public class TypeCastingAndStrConcatenate {
    public static void main(String[] args) {
        // Typecasting examples
        int num = 10;
        double decimal = 5.5;
        
        // Implicit casting (int to double)
        double result1 = num + decimal;
        System.out.println("Result of implicit casting (int to double): " + result1);
        
        // Explicit casting (double to int)
        int result2 = (int)(decimal + num);
        System.out.println("Result of explicit casting (double to int): " + result2);

        // String concatenation example
        String text1 = "Hello";
        String text2 = "World";
        int number = 2025;
        
        // Concatenating strings
        String result3 = text1 + " " + text2 + " " + number;
        System.out.println("String concatenation result: " + result3);
    }
}
