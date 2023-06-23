package com.example.herrdone.controller;


import com.example.herrdone.DTO.Request.LoginReq;
import com.example.herrdone.config.security.annotation.AuthCheck;
import com.example.herrdone.exception.BusinessException;
import com.example.herrdone.service.AuthService;
import com.example.herrdone.util.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public Object login(@RequestBody LoginReq loginReq){
        try {
            return new CommonResponse<>(HttpStatus.OK, "로그인 성공", authService.login(loginReq));
        } catch (BusinessException e){
            return e.getErrorCode();
        }
    }


}
