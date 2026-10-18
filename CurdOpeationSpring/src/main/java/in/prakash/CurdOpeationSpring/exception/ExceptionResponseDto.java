package in.prakash.CurdOpeationSpring.exception;

import java.time.LocalDateTime;

public class ExceptionResponseDto {
 private LocalDateTime timestamp;
 private int statusCode;
 private  String error;
 private  String message;
 private String path;
public ExceptionResponseDto(LocalDateTime timestamp,int statusCode,String error,String message,String path){
    this.error=error;
    this.message=message;
    this.path=path;
    this.statusCode=statusCode;
    this.timestamp=timestamp;
}

    public String error() {
        return error;
    }

    public ExceptionResponseDto setError(String error) {
        this.error = error;
        return this;
    }

    public String message() {
        return message;
    }

    public ExceptionResponseDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public String path() {
        return path;
    }

    public ExceptionResponseDto setPath(String path) {
        this.path = path;
        return this;
    }

    public int statusCode() {
        return statusCode;
    }

    public ExceptionResponseDto setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public LocalDateTime timestamp() {
        return timestamp;
    }

    public ExceptionResponseDto setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
