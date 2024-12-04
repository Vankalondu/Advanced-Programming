/**
 * DepositTransaction class handles deposit operations.
 */
public class DepositTransaction extends BaseTransaction {

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
     * - The deposit amount must be a positive value.
     * 
     * Post-condition:
     * - The bank account's balance increases by the deposit amount.
     */
    @Override
    public void apply(BankAccount ba) {
        try {
            // Validate the deposit amount
            if (amount <= 0) {
                throw new InvalidTransactionException("Deposit amount must be greater than zero.");
            }

            ba.deposit(amount); // Perform the deposit
            System.out.println("Deposited " + amount + " to account.");
        } catch (InvalidTransactionException e) {
            System.out.println(e.getMessage());  // Handle invalid deposit amount error
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());  // Handle any unexpected errors
        }
    }
}
