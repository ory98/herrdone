package com.example.herrdone.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ErrorCode {
    INVALID_INPUT_VALUE("CD01", "Invalid Input Value"),
    ENTITY_NOT_FOUND("CD02", "Entity Not Found"),
    DB_CONNECTION_REFUSED("CD03", "Database Connection is Refused"),
    DUPLICATED_DATA("CD04", "Duplicated Data"),
    CANNOT_FIND_USER("CD05", "Cannot Find User"),
    NO_PARAM("CD06", "Parameters Are Empty"),
    NOT_CORRECT_SIGN_IN("CD07", "Invalid Email or Password"),
    INVALID_TOKEN("CD08", "Invalid Token");

    private final String code;
    private final String message;

    ErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }
}
