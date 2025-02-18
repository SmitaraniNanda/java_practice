package com.questk2.Bank;

/**
 * Exception thrown when an invalid amount (negative deposit) is entered.
 */
public class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}
