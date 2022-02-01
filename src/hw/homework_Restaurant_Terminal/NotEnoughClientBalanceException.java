package hw.homework_Restaurant_Terminal;

public class NotEnoughClientBalanceException extends RuntimeException {
    public NotEnoughClientBalanceException(String message) {
        super(message);
    }
}
