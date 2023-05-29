package com.example.herrdone.controller;

import com.example.herrdone.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.herrdone.service.UserService;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public CommonResponse home() {
        CommonResponse result = new CommonResponse();
        try {

        } catch (Exception e){

        }

        return result;
    }



}
