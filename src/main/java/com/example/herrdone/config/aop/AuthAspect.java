package com.example.herrdone.config.aop;

import com.example.herrdone.config.security.JwtManager;
import com.example.herrdone.exception.BusinessException;
import com.example.herrdone.exception.ErrorCode;
import com.example.herrdone.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class AuthAspect {

    private final JwtManager jwtManager;
    private final MemberRepository memberRepository;

    @Before("@annotation(com.example.herrdone.config.security.annotation.AuthCheck)")
    public void vaildMember() {

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        String token = request.getHeader("Authorization");
        String emailCheck = jwtManager.getMemberEmail(token);

        if(!memberRepository.existsMemberByEmail(emailCheck)){
            throw new BusinessException(ErrorCode.INVALID_TOKEN);
        }

        request.setAttribute("email", emailCheck);
    }

}
