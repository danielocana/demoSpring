package rancheros.com.domain;

/**
 * Created by Daniel on 11/06/2016.
 */
public class ErrorMessage {

    private String errorCode;
    private String message;
    private String field;

    public ErrorMessage() {
    }

    public ErrorMessage(String errorCode, String message, String field) {
        this.errorCode = errorCode;
        this.message = message;
        this.field = field;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }
}
