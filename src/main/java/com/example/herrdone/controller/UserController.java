package com.example.herrdone.controller;

import com.example.herrdone.service.MemberService;
import com.example.herrdone.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private final MemberService memberService;

    public UserController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/user")
    public CommonResponse findAllUser() {
        // Pageable
        CommonResponse result = new CommonResponse();

        try {
            result.setData(memberService.userList());
        } catch (Exception e){

        }

        return result;
    }



}
