/**
 * WithdrawalTransaction class handles withdrawal operations.
 */
public class WithdrawalTransaction extends BaseTransaction {

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
            // Validate the withdrawal amount
            if (amount <= 0) {
                throw new InvalidTransactionException("Withdrawal amount must be greater than zero.");
            }

            // Check if the account has enough balance
            if (ba.getBalance() < amount) {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }

            ba.withdraw(amount);  // Perform the withdrawal
            System.out.println("Withdrew " + amount + " from account.");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());  // Handle insufficient funds error
        } catch (InvalidTransactionException e) {
            System.out.println(e.getMessage());  // Handle invalid transaction error (e.g., negative withdrawal)
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());  // Handle any unexpected errors
        }
    }
}
