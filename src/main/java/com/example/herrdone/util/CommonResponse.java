package com.example.herrdone.util;

import lombok.Getter;

public record CommonResponse<T>(
    String ResultCode,
    String ResultMsg,
    T Data
) { }


