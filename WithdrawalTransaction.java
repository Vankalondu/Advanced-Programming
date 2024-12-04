/**
 * WithdrawalTransaction class handles withdrawal operations.
 */
public class WithdrawalTransaction extends BaseTransaction {

    /**
     * Constructs a WithdrawalTransaction object.
     * 
     * @param amount        the withdrawal amount
     * @param date          the date of the withdrawal
     * @param transactionID a unique identifier for the transaction
     * 
     * Requires:
     * - `amount` must be positive.
     * - `date` must not be null.
     * - `transactionID` must be unique.
     * 
     * Produces:
     * - A new WithdrawalTransaction instance.
     * 
     * Pre-condition:
     * - The BankAccount exists and is initialized.
     * 
     * Post-condition:
     * - The transaction object is created with the provided parameters.
     */
    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    /**
     * Applies the withdrawal to the given bank account.
     * 
     * @param ba the bank account from which the withdrawal is applied
     * 
     * Pre-condition:
     * - The BankAccount object must not be null.
     * - The bank account balance must be greater than or equal to the withdrawal amount.
     * 
     * Post-condition:
     * - The bank account's balance decreases by the withdrawal amount, or an exception is thrown.
     */
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
