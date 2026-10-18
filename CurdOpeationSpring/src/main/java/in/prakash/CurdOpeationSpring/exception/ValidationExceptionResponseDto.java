package in.prakash.CurdOpeationSpring.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionResponseDto {
    private LocalDateTime timestamp;
    private int statusCode;
    private  String error;
    private  String message;
    private String path;
    private Map<String,String>fieldErrors;

    public ValidationExceptionResponseDto(LocalDateTime timestamp,int statusCode,String error,String message,String path,Map<String, String> fieldErrors) {
        this.timestamp=timestamp;
        this.statusCode=statusCode;
        this.error=error;
        this.message=message;
        this.path=path;
        this.fieldErrors=fieldErrors;
    }

    public String error() {
        return error;
    }

    public ValidationExceptionResponseDto setError(String error) {
        this.error = error;
        return this;
    }

    public Map<String, String> fieldErrors() {
        return fieldErrors;
    }

    public ValidationExceptionResponseDto setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
        return this;
    }

    public String message() {
        return message;
    }

    public ValidationExceptionResponseDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public String path() {
        return path;
    }

    public ValidationExceptionResponseDto setPath(String path) {
        this.path = path;
        return this;
    }

    public int statusCode() {
        return statusCode;
    }

    public ValidationExceptionResponseDto setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public LocalDateTime timestamp() {
        return timestamp;
    }

    public ValidationExceptionResponseDto setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
