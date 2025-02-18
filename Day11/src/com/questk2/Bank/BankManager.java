package com.questk2.Bank;
/**
 * Manages bank accounts and handles account validation.
 */
public class BankManager {
    private BankAccount account1 = new BankAccount(101, 5000);
    private BankAccount account2 = new BankAccount(103, 10000);

    /**
     * Validates and retrieves the bank account.
     * @param accountNumber The account number to validate.
     * @return The BankAccount object if valid.
     * @throws InvalidAmountException if the account number is invalid.
     */
    public BankAccount getAccount(int accountNumber) throws InvalidAmountException {
        if (accountNumber == account1.getAccountNumber()) {
            return account1;
       
        } else {
            throw new InvalidAmountException("Invalid account number!");
        }
    }
}
