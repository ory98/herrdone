package com.example.herrdone.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
public class CommonResponse<T> {
    private String ResultCode;
    private String ResultMsg;
    private T data;


}
