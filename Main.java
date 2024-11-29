import java.util.Calendar;

/**
 * Main class to test DepositTransaction, WithdrawalTransaction, and the system.
 */
public class Main {
    public static void main(String[] args) {
        // Create a Calendar instance for the transaction date
        Calendar date = Calendar.getInstance();

        // Create a BankAccount object
        BankAccount account = new BankAccount(5000); // Initial balance: 5000

        // Test DepositTransaction
        DepositTransaction deposit = new DepositTransaction(2000, date, "D001");
        System.out.println("\nPerforming Deposit Transaction:");
        deposit.apply(account); // Apply deposit
        deposit.printTransactionDetails();
        System.out.println("Balance after deposit: " + account.getBalance());

        // Test WithdrawalTransaction
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(1000, date, "W001");
        System.out.println("\nPerforming Withdrawal Transaction:");
        withdrawal.apply(account); // Apply withdrawal
        withdrawal.printTransactionDetails();
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Test Reversal
        System.out.println("\nReversing Withdrawal Transaction:");
        withdrawal.reverse(account); // Reverse the withdrawal
        System.out.println("Balance after reversal: " + account.getBalance());
    }
}
