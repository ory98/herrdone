package com.example.herrdone.config.aop;

import com.example.herrdone.config.security.JwtManager;
import com.example.herrdone.entity.Member;
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

    @Before("@annotation(com.example.herrdone.config.security.annotation.NeedLogin)")
    public void vaildMember() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes(); // 현재 온 요청 객체를 불러옴
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest(); // 그 요청 객체에서 HttpServletRequest 객체를 가져옴

        String token = request.getHeader("Authorization"); // HttpServletRequest 객체에서 토큰을 할당한 Authorization의 값을 가져옴
        String email = jwtManager.getMemberEmail(token); // 토큰으로 이메일 값을 뽑아냄
        String memberType = jwtManager.getMemberType(token); // 토큰으로 멤버 타입을 뽑아냄

        if(!memberRepository.existsMemberByEmail(email)){ // 이메일을 DB에서 찾아봤는데 없으면
            throw new BusinessException(ErrorCode.INVALID_TOKEN); // 에러 내보냄
        }

        request.setAttribute("email", email); // 만약에 찾아봤는데 있으면 HttpServletRequest 객체에 email이라는 키값을 만들어서 거기에 할당해줌
        request.setAttribute("memberType", memberType);
    }

    @Before("@annotation(com.example.herrdone.config.security.annotation.NeedAdmin)")
    public void validAdmin(){
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes(); // 현재 온 요청 객체를 불러옴
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest(); // 그 요청 객체에서 HttpServletRequest 객체를 가져옴

        String token = request.getHeader("Authorization"); // HttpServletRequest 객체에서 토큰을 할당한 Authorization의 값을 가져옴
        String email = jwtManager.getMemberEmail(token); // 토큰으로 이메일 값을 뽑아냄
        if(!memberRepository.existsMemberByEmail(email)){ // 이메일을 DB에서 찾아봤는데 없으면
            throw new BusinessException(ErrorCode.INVALID_TOKEN); // 에러 내보냄
        }
        String memberType = jwtManager.getMemberType(token); // 토큰으로 멤버 타입을 뽑아냄

        if(!memberType.equals(Member.MemberType.ADMIN.getType())){
            throw new BusinessException(ErrorCode.INVALID_TOKEN);
        }

        request.setAttribute("memberType", memberType);
    }
}
