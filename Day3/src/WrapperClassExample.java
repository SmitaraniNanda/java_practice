public class WrapperClassExample {
    public static void main(String[] args) {
        // AutoBoxing: int to Integer
        int primitiveInt = 100;
        Integer wrappedInt = primitiveInt;  // AutoBoxing
        System.out.println("AutoBoxing (int to Integer): " + wrappedInt);

        // UnBoxing: Integer to int
        Integer wrappedInt2 = 200;
        int primitiveInt2 = wrappedInt2;  // UnBoxing
        System.out.println("UnBoxing (Integer to int): " + primitiveInt2);

        // String to Integer using Integer.parseInt()
        String strNumber = "123";
        int parsedInt = Integer.parseInt(strNumber);
        System.out.println("String to Integer: " + parsedInt);

        // Integer to String
        Integer num = 456;
        String strValue = num.toString(); // Using toString() method
        System.out.println("Integer to String: " + strValue);
    }
}
