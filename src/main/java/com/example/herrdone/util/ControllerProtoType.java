package com.example.herrdone.util;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProtoType {


    @GetMapping("/proto_type")
    public CommonResponse home() {
        CommonResponse result = new CommonResponse();

        try {

        } catch (Exception e){

        }

        return result;
    }
}