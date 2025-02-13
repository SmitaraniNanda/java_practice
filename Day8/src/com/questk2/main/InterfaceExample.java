package com.questk2.main;

//FirstInterface defines a method that must be implemented by any class that implements this interface.
 
interface FirstInterface {
  
 //Abstract method to be implemented by a class.
  public void myMethod();
}


 //SecondInterface defines another method that must be implemented by any class that implements this interface.
 
interface SecondInterface {
  
   // Abstract method to be implemented by a class.
   
  public void myOtherMethod();
}

/**
 * DemoClass implements both FirstInterface and SecondInterface.
 * It provides concrete implementations for the abstract methods.
 */
class DemoClass implements FirstInterface, SecondInterface {
  
  /**
   * Implements myMethod from FirstInterface.
   * Prints a simple message to the console.
   */
  public void myMethod() {
    System.out.println("Some text..");
  }

  /*
    Implements myOtherMethod from SecondInterface.
    Prints another message to the console.
   */
  public void myOtherMethod() {
    System.out.println("Some other text...");
  }
}


 // InterfaceExample is the main class that contains the main method to run the program.
class InterfaceExample {
  /**
   * The main method is the entry point of the program.
   * 
   * @param args Command-line arguments (not used in this program).
   */
  public static void main(String[] args) {
    DemoClass myObj = new DemoClass();
    myObj.myMethod();
    myObj.myOtherMethod();
  }
}
