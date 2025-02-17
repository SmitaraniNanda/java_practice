// Custom Exception for Insufficient Funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class CustomExample {

    /**
     * Withdraws money from an account.
     * @param balance The current account balance.
     * @param amount The amount to withdraw.
     * @throws InsufficientFundsException if amount is greater than balance.
     */
    public static void withdraw(int balance, int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Error: Insufficient funds! Available balance: $" + balance);
        }
        System.out.println("Withdrawal successful!" );
    }

    public static void main(String[] args) {
        int balance = 500; //  balance
        int withdrawAmount = 700; // Trying to withdraw more than balance

        try {
            withdraw(balance, withdrawAmount);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
