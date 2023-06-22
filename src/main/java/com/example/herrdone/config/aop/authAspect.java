package com.example.herrdone.config.aop;

import com.example.herrdone.config.security.JwtManager;
import com.example.herrdone.controller.AuthController;
import com.example.herrdone.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class authAspect {

    private final JwtManager jwtManager;
    private final MemberRepository memberRepository;
    private final AuthController authController;

    private final HttpServletResponse response;

    @Before("@annotation(com.example.herrdone.config.logging.annotation.NoLogging)")
    public void vaildMember() throws IOException {

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        // postman에서 테스트를 위해 header부분에 임의로 넣어준 토큰 데이터
        String s = request.getHeader("Authorization");
        // 토큰 가져와서 email 추출
        String emailCheck = jwtManager.getMemberEmail(s);
        // db 검증
        Boolean valid = memberRepository.existsMemberByEmail(emailCheck);

        // 클라이언트에 응답
        if (valid) { // 검증 성공
            return ;

        } else { // 검증 실패

        }
    }




}
