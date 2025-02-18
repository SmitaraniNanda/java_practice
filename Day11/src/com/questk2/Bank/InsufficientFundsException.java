package com.questk2.Bank;

/**
 * Exception thrown when attempting to withdraw more money than available balance.
 */
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
