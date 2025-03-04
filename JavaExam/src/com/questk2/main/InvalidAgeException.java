package com.questk2.main;

//Custom Exception for Invalid Age
class InvalidAgeException extends Exception {
 /**
  * Constructor for InvalidAgeException
  * @param message Error message to be displayed
  */
 public InvalidAgeException(String message) {
     super(message);
 }
}