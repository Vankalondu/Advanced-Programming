/**
 * InsufficientFundsException class represents a custom exception.
 * Thrown when an account has insufficient funds for a withdrawal.
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
