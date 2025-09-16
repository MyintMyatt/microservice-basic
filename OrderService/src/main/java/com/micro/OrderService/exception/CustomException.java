package com.micro.OrderService.exception;

public class CustomException extends RuntimeException {

    private String errorStatus;
    private int errorCode;

    public CustomException(String message, String errorStatus, int errorCode) {
        super(message);
        this.errorStatus=errorStatus;
        this.errorCode=errorCode;
    }

    public String getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
