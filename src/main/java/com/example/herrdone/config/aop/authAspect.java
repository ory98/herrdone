package com.example.herrdone.config.aop;

import com.example.herrdone.config.security.CustomPrincipal;
import com.example.herrdone.config.security.JwtManager;
import com.example.herrdone.controller.AuthController;
import com.example.herrdone.entity.Member;
import com.example.herrdone.exception.BusinessException;
import com.example.herrdone.exception.ErrorCode;
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
    public void vaildMember() throws BusinessException {

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        CustomPrincipal customPrincipal = new CustomPrincipal((Member) request);

        // 발급된 tocken 가져오기
        String token = jwtManager.generateAccessToken(customPrincipal);
        // 토큰 가져와서 email 추출
        String getEmail = jwtManager.getMemberEmail(token);
        // db 검증 > 바로 db에 넣어서 할 수 있나요,,,(질문)
        Boolean valid = memberRepository.existsMemberByEmail(getEmail);

        // 검증 실패
        if (!valid) {
            new BusinessException(ErrorCode.NOT_CORRECT_SIGN_IN);
        }
        // 성공 시 컨트롤러 이동,,,
    }




}
