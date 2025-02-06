public class TypeCastingExample {
    public static void main(String[] args) {
        // Widening: int to double
        int intValue = 42;
        double doubleValue = intValue;  // Implicit casting (widening)
        System.out.println("Int to Double: " + doubleValue);

        // Narrowing: double to int
        double doubleValue2 = 42.99;
        int intValue2 = (int) doubleValue2;  // Explicit casting (narrowing)
        System.out.println("Double to Int: " + intValue2);

        // Char to Int
        char charValue = 'A';
        int charToInt = charValue;  // Implicit casting (ASCII value)
        System.out.println("Char to Int: " + charToInt);

        // Int to Char
        int intToCharValue = 66;
        char intToChar = (char) intToCharValue;  // Explicit casting
        System.out.println("Int to Char: " + intToChar);
    }
}
