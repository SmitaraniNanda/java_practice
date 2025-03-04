package com.questk2.main;

//Custom Exception for Low Salary
class LowSalaryException extends Exception {
 /**
  * Constructor for LowSalaryException
  * @param message Error message to be displayed
  */
 public LowSalaryException(String message) {
     super(message);
 }
}
