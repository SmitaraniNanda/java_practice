public class ExampleMethodLoad {
    
    // Method with no parameters
    void add() {
        System.out.println("no-arg add");
    }
    
    // Method overloading with an integer parameter
    void add(int a) {
        System.out.println("int-arg add");
    }
    
    // Method overloading with a string parameter
    void add(String str) {
        System.out.println("String-arg add");
    }
    
    
    // This method is commented out because it conflicts with the existing add(String) method
    // due to having the same method signature (parameter type and order), even though it has a return type.
   /* int add(String s) {
        System.out.println("String-arg add");
        return 10;
    }
    */
    
    // Main method to execute the program
    public static void main(String[] args) {
        ExampleMethodLoad exmethodload = new ExampleMethodLoad();
        
        // Calling overloaded methods
        exmethodload.add();       // Calls the no-argument method
        exmethodload.add(10);      // Calls the method with an integer argument
        exmethodload.add("abc");  // Calls the method with a string argument
    }
}
