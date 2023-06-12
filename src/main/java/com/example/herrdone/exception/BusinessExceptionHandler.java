package com.example.herrdone.exception;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class BusinessExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public ErrorResponse handleException(BusinessException e, HttpServletRequest req){
        log.error(
                "\nerrorCode : " + e.getErrorCode() +
                "\nURI : " + req.getRequestURI() +
                "\nMessage : " + e.getMessage()
        );

        return ErrorResponse.builder()
                .errorCode(e.getErrorCode())
                .errorMessage(e.getMessage())
                .build();
    }

}
