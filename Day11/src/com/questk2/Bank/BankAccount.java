package com.questk2.Bank;

public class BankAccount {
	
	/**
	 * Represents a bank account with deposit, withdraw, and balance check features.
	 */
	
	    private int accountNumber;
	    private double balance;

	    /**
	     * Constructor to initialize BankAccount.
	     * @param accountNumber The unique account number.
	     * @param balance The initial balance.
	     */
	    public BankAccount(int accountNumber, double balance) {
	        this.accountNumber = accountNumber;
	        this.balance = balance;
	    }
	    /**
	     * sets the account number.
	     * @return Account number.
	     */
	    
	    public int setAccountNumber() {
	    	return accountNumber;
	    }

	    /**
	     * Gets the account number.
	     * @return Account number.
	     */
	    public int getAccountNumber() {
	        return accountNumber;
	    }

	    /**
	     * Deposits money into the account.
	     * @param amount The amount to deposit.
	     * @throws InvalidAmountException if amount is negative.
	     */
	    public void deposit(double amount) throws InvalidAmountException {
	        if (amount < 0) {
	            throw new InvalidAmountException("Deposit amount cannot be negative.");
	        }
	        balance += amount;
	        System.out.println("Deposit successful! New balance: " + balance);
	    }

	    /**
	     * Withdraws money from the account.
	     * @param amount The amount to withdraw.
	     * @throws InsufficientFundsException if amount exceeds balance.
	     */
	    public void withdraw(double amount) {
	        if (amount > balance) {
	            throw new InsufficientFundsException("Insufficient balance for withdrawal.");
	        }
	        balance -= amount;
	        System.out.println("Withdrawal successful! Remaining balance: " + balance);
	    }

	    /**
	     * Displays the current balance.
	     */
	    public void checkBalance() {
	        System.out.println("Current Balance: " + balance);
	    }
	

}
