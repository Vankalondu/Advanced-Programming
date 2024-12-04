import java.util.Calendar;

/**
 * Main class to test the transaction system.
 */
public class Main {
    public static void main(String[] args) {
        // Create a BankAccount instance
        BankAccount account = new BankAccount(5000); // Initial balance: 5000

        // Create Calendar instance for the date
        Calendar date = Calendar.getInstance();

        // Test BaseTransaction default behavior
        BaseTransaction baseTransaction = new BaseTransaction(0, date, "BT001");
        System.out.println("\nTesting BaseTransaction:");
        baseTransaction.apply(account); // Should display the default apply() message
        baseTransaction.printTransactionDetails();

        // Test DepositTransaction
        DepositTransaction deposit = new DepositTransaction(2000, date, "DT001");
        System.out.println("\nTesting DepositTransaction:");
        deposit.apply(account);
        deposit.printTransactionDetails();
        System.out.println("Balance after deposit: " + account.getBalance());

        // Test WithdrawalTransaction
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(1000, date, "WT001");
        System.out.println("\nTesting WithdrawalTransaction:");
        withdrawal.apply(account);
        withdrawal.printTransactionDetails();
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Test InsufficientFundsException
        WithdrawalTransaction failedWithdrawal = new WithdrawalTransaction(10000, date, "WT002");
        System.out.println("\nTesting InsufficientFundsException:");
        failedWithdrawal.apply(account); // Should print an error message
        failedWithdrawal.printTransactionDetails();
    }
}
