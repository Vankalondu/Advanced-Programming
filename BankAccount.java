/**
 * BankAccount class manages the account balance.
 * Provides methods for deposits and withdrawals.
 */
public class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw money from the account
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough funds to withdraw " + amount + ".");
        }
        balance -= amount;
    }
}
