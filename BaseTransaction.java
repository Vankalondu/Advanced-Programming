import java.util.Calendar;

/**
 * BaseTransaction class represents a general financial transaction.
 */
public class BaseTransaction implements TransactionInterface {
    protected double amount;
    protected Calendar date;
    protected String transactionID;

    /**
     * Constructs a BaseTransaction object.
     * 
     * @param amount        the transaction amount
     * @param date          the date of the transaction
     * @param transactionID a unique identifier for the transaction
     * 
     * Requires:
     * - `amount` must be a non-negative double.
     * - `date` must not be null.
     * - `transactionID` must be a non-empty, unique string.
     * 
     * Produces:
     * - A new BaseTransaction instance.
     * 
     * Pre-condition:
     * - The transaction ID is unique within the system.
     * 
     * Post-condition:
     * - A BaseTransaction object is created and initialized with the provided parameters.
     */
    public BaseTransaction(double amount, Calendar date, String transactionID) {
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    /**
     * Returns the transaction amount.
     * 
     * @return the transaction amount
     * 
     * Produces:
     * - The double value representing the transaction amount.
     * 
     * Pre-condition:
     * - The transaction object must be initialized.
     * 
     * Post-condition:
     * - The transaction amount is returned unchanged.
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the transaction date.
     * 
     * @return the transaction date as a Calendar object
     * 
     * Produces:
     * - A Calendar object representing the transaction date.
     * 
     * Pre-condition:
     * - The transaction object must be initialized.
     * 
     * Post-condition:
     * - The transaction date is returned unchanged.
     */
    @Override
    public Calendar getDate() {
        return date;
    }

    /**
     * Returns the transaction ID.
     * 
     * @return the transaction ID as a string
     * 
     * Produces:
     * - A unique string representing the transaction ID.
     * 
     * Pre-condition:
     * - The transaction object must be initialized.
     * 
     * Post-condition:
     * - The transaction ID is returned unchanged.
     */
    @Override
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Prints the transaction details.
     * 
     * Pre-condition:
     * - The transaction object must be initialized.
     * 
     * Post-condition:
     * - The transaction details are printed to the console.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    /**
     * Default implementation of apply().
     * 
     * @param ba the bank account on which the transaction is applied
     * 
     * Pre-condition:
     * - The BankAccount object must not be null.
     * 
     * Post-condition:
     * - No changes are made to the BankAccount.
     */
    @Override
    public void apply(BankAccount ba) {
        System.out.println("Default apply() method: No transaction applied.");
    }
}
