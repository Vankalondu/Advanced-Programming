/**
 * DepositTransaction class handles deposit operations.
 */
public class DepositTransaction extends BaseTransaction {

    /**
     * Constructs a DepositTransaction object.
     * 
     * @param amount        the deposit amount
     * @param date          the date of the deposit
     * @param transactionID a unique identifier for the transaction
     * 
     * Requires:
     * - `amount` must be positive.
     * - `date` must not be null.
     * - `transactionID` must be unique.
     * 
     * Produces:
     * - A new DepositTransaction instance.
     * 
     * Pre-condition:
     * - The BankAccount exists and is initialized.
     * 
     * Post-condition:
     * - The transaction object is created with the provided parameters.
     */
    public DepositTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    /**
     * Applies the deposit to the given bank account.
     * 
     * @param ba the bank account to which the deposit is applied
     * 
     * Pre-condition:
     * - The BankAccount object must not be null.
     * 
     * Post-condition:
     * - The bank account's balance increases by the deposit amount.
     */
    @Override
    public void apply(BankAccount ba) {
        ba.deposit(amount);
        System.out.println("Deposited " + amount + " to account.");
    }
}
