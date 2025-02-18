package com.questk2.Bank;

/**
 * Manages bank accounts and handles account validation.
 */
public class BankManager {
    private BankAccount[] accounts;
    private int accountCount;

    /**
     * Constructor initializes an empty bank manager with a fixed capacity.
     */
    public BankManager() {
        this.accounts = new BankAccount[10]; // Maximum of 10 accounts (can be increased)
        this.accountCount = 0;
    }

    /**
     * Adds a new account to the bank.
     * @param account The BankAccount object to add.
     */
    public void addAccount(BankAccount account) {
        if (accountCount < accounts.length) {
            accounts[accountCount++] = account;
        } else {
            System.out.println("Bank account limit reached. Cannot add more accounts.");
        }
    }

    /**
     * Retrieves an account if it exists.
     * @param accountNumber The account number to retrieve.
     * @return The BankAccount object if found.
     * @throws InvalidAccountException if the account number does not exist.
     */
    public BankAccount getAccount(int accountNumber) throws InvalidAmountException {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        throw new InvalidAmountException("Invalid account number!");
    }
}
