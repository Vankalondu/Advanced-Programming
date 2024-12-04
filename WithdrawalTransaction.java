/**
 * WithdrawalTransaction class handles withdrawal operations.
 */
public class WithdrawalTransaction extends BaseTransaction {

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
        }
    }
}
