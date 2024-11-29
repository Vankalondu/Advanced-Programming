/**
 * WithdrawalTransaction class handles withdrawal operations.
 * Decreases the account balance by the withdrawal amount.
 */
public class WithdrawalTransaction extends BaseTransaction {

    // Constructor
    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) {
        try {
            if (ba.getBalance() < amount) {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }
            ba.withdraw(amount);
            System.out.println("Withdrew " + amount + " from account.");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Withdrawal transaction completed.");
        }
    }

    // Reversal method to restore the withdrawn amount
    public boolean reverse(BankAccount ba) {
        ba.deposit(amount);
        System.out.println("Reversed withdrawal of " + amount + ".");
        return true;
    }
}
