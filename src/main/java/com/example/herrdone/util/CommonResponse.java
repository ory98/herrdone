package com.example.herrdone.util;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public record CommonResponse<T>(
    HttpStatus ResultCode,
    String ResultMsg,
    T Data
) { }


