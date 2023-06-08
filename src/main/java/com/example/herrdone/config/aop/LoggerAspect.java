package com.example.herrdone.config.aop;


import com.example.herrdone.util.ConnectionUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class LoggerAspect {

    private final ConnectionUtil connectionUtil;

    private final Log log = LogFactory.getLog(LoggerAspect.class);

    public LoggerAspect(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    @Pointcut("execution(* com.example.herrdone.controller.*Controller.*(..))")
    private void controllerCut(){  }

    @Pointcut("execution(* com.example.herrdone.service.*Service.*(..))")
    private void serviceCut(){  }

    @Before("controllerCut()")
    public void controllerLoggerAdvice(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();

        String typeName = signature.getDeclaringType().toString();
        String methodName = signature.getName();

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        log.info(
                "\nHTTP REQUEST" +
                "\nClient IP : " + connectionUtil.getClientIP(request) +
                "\nRequest URL : " + request.getServletPath() +
                "\nHandle Controller : " + typeName +
                "\nMethod : " + methodName + "\n"
        );
    }

    @AfterReturning(pointcut = "controllerCut()", returning = "result")
    public void controllerLogAfter(JoinPoint joinPoint, Object result){
        log.info(
                "\nHTTP RESPONSE" +
                "\nController Method : " + joinPoint.getSignature().getName() +
                "\nMethod Return Value : " + result + "\n"
        );
    }
}
