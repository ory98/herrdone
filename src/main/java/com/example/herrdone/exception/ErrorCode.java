package com.example.herrdone.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ErrorCode {
    INVALID_INPUT_VALUE("CD01", "Invalid Input Value"),
    ENTITY_NOT_FOUND("CD02", "Entity Not Found"),
    DB_CONNECTION_REFUSED("CD03", "Database Connection is Refused"),
    DUPLICATED_EMAIL("CD04", "Duplicated Email"),
    CANNOT_FIND_USER("CD05", "Cannot Find User");

    private final String code;
    private final String message;

    ErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }
}
