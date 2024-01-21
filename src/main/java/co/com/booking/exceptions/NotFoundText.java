package co.com.booking.exceptions;

public class NotFoundText extends AssertionError {
    public static final String THE_VALUE_IS_NOT_EXPECT = "The value is not expected";

    public NotFoundText(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundText(String message) {
        super(message);
    }

}
