package hw.homework_data;

public class DateInvalidFormatExeption extends Exception {

    public DateInvalidFormatExeption() {
    }

    public DateInvalidFormatExeption(String message) {
        super(message);
    }

    public DateInvalidFormatExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public DateInvalidFormatExeption(Throwable cause) {
        super(cause);
    }

    public DateInvalidFormatExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
