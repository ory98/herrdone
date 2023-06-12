package com.example.herrdone.exception;


import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private ErrorCode errorCode;
    private String errorMessage;
}
