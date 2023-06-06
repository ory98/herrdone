package com.example.herrdone.util;

import lombok.Getter;

@Getter
public class CommonResponse<T> {
    private String ResultCode;
    private String ResultMsg;
    private T Data;

    public CommonResponse(String resultCode, String resultMsg , T data) {
        ResultCode = resultCode;
        ResultMsg = resultMsg;
        Data = data;
    }

}


