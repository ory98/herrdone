package com.example.herrdone.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ErrorCode {
    INVALID_INPUT_VALUE("CD01", "Invalid Input Value"),
    ENTITY_NOT_FOUND("CD02", "Entity Not Found"),
    DB_CONNECTION_REFUSED("CD03", "Database Connection is Refused");

    private final String code;
    private final String message;

    private ErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }
}
