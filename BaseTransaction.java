import java.util.Calendar;

/**
 * BaseTransaction class represents a general financial transaction.
 */
public class BaseTransaction implements TransactionInterface {
    protected double amount;
    protected Calendar date;
    protected String transactionID;

    // Constructor
    public BaseTransaction(double amount, Calendar date, String transactionID) {
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    /**
     * Default implementation of apply().
     */
    @Override
    public void apply(BankAccount ba) {
        System.out.println("Default apply() method: No transaction applied.");
    }
}
