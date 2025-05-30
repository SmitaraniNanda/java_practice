package com.questk2.Bank;


import java.util.Scanner;

/**
 * The main application for the banking system.
 */
public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankManager bankManager = new BankManager();

        System.out.print("Enter your account number to create a new account: ");
        int accountNumber = scanner.nextInt();
        
        System.out.print("Enter initial deposit amount: ");
        double initialBalance = scanner.nextDouble();

        try {
            if (initialBalance < 0) {
                throw new InvalidAmountException("Initial deposit cannot be negative.");
            }
            
            // Creating and adding a new account based on user input
            BankAccount userAccount = new BankAccount(accountNumber, initialBalance);
            bankManager.addAccount(userAccount);
            System.out.println("Account created successfully!");

            boolean running = true;

            while (running) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        try {
                            userAccount.deposit(depositAmount);
                        } catch (InvalidAmountException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        try {
                            userAccount.withdraw(withdrawAmount);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 3:
                        userAccount.checkBalance();
                        break;
                    case 4:
                        System.out.println("Exiting the banking system. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Thank you for using our banking system!");
        }
    }
}
