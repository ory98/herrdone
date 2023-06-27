package com.example.herrdone.service;


import com.example.herrdone.DTO.Request.LoginReq;
import com.example.herrdone.DTO.Response.LoginRes;
import com.example.herrdone.config.security.CustomPrincipal;
import com.example.herrdone.config.security.JwtManager;
import com.example.herrdone.entity.Member;
import com.example.herrdone.exception.BusinessException;
import com.example.herrdone.exception.ErrorCode;
import com.example.herrdone.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtManager jwtManager;


    public LoginRes login(LoginReq loginReq){
        Optional<Member> member = memberRepository.findByEmail(loginReq.id());
        if(member == null){
            throw new BusinessException(ErrorCode.CANNOT_FIND_USER);
        }

        // DB에 암호화가 되어있지 않아 애러 발생 > 임시로 코드 작성
        // 임시로 했으면 다시 돌려놔야지?
        if(!passwordEncoder.matches(loginReq.pw(), member.get().getPassword())){
//        if (!loginReq.pw().equals(member.getPassword())){
            throw new BusinessException(ErrorCode.NOT_CORRECT_SIGN_IN);
        }

        CustomPrincipal customPrincipal = new CustomPrincipal(member.get());

        return new LoginRes(loginReq.id(), jwtManager.generateAccessToken(customPrincipal));
    }

}
