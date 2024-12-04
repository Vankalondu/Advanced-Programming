import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Initialize a bank account with a starting balance of 5000
        BankAccount account = new BankAccount(5000); // Initial balance: 5000

        // Create a Calendar instance for the current date
        Calendar date = Calendar.getInstance();

        // Example: Valid deposit transaction
        try {
            DepositTransaction deposit = new DepositTransaction(1000, date, "DT001");
            deposit.apply(account);  // This should work fine
            deposit.printTransactionDetails();
            System.out.println("Balance after deposit: " + account.getBalance());
        } catch (InvalidTransactionException e) {
            System.out.println("Error during deposit: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error during deposit: " + e.getMessage());
        }

        // Example: Invalid deposit (negative amount)
        try {
            DepositTransaction invalidDeposit = new DepositTransaction(-500, date, "DT002");
            invalidDeposit.apply(account);  // This should throw an exception
            invalidDeposit.printTransactionDetails();
        } catch (InvalidTransactionException e) {
            System.out.println("Error during deposit: " + e.getMessage());  // Expected error: negative deposit amount
        } catch (Exception e) {
            System.out.println("Unexpected error during deposit: " + e.getMessage());
        }

        // Example: Valid withdrawal transaction
        try {
            WithdrawalTransaction withdrawal = new WithdrawalTransaction(1500, date, "WT001");
            withdrawal.apply(account);  // This should work fine
            withdrawal.printTransactionDetails();
            System.out.println("Balance after withdrawal: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Error during withdrawal: " + e.getMessage());  // Expected error: insufficient funds
        } catch (Exception e) {
            System.out.println("Unexpected error during withdrawal: " + e.getMessage());
        }

        // Example: Invalid withdrawal (insufficient funds)
        try {
            WithdrawalTransaction invalidWithdrawal = new WithdrawalTransaction(10000, date, "WT002");
            invalidWithdrawal.apply(account);  // This should throw an exception
            invalidWithdrawal.printTransactionDetails();
        } catch (InsufficientFundsException e) {
            System.out.println("Error during withdrawal: " + e.getMessage());  // Expected error: insufficient funds
        } catch (Exception e) {
            System.out.println("Unexpected error during withdrawal: " + e.getMessage());
        }
    }
}
