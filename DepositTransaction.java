/**
 * DepositTransaction class handles deposit operations.
 * Increases the account balance by the deposit amount.
 */
public class DepositTransaction extends BaseTransaction {

    // Constructor
    public DepositTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) {
        ba.deposit(amount); // Deposit the specified amount
        System.out.println("Deposited " + amount + " to account.");
    }
}
