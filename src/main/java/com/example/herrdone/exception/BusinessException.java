package com.example.herrdone.exception;


public class BusinessException extends RuntimeException {
    private ErrorCode errorCode;

    public final ErrorCode getErrorCode() {return this.getErrorCode();}

    public BusinessException (ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

}
