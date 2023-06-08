package com.example.herrdone.config.aop;


import jakarta.servlet.http.HttpServletRequest;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class LoggerAspect {

    public KLogger log;

    public KLogger getLog() {
        return this.log;
    }

    @Pointcut("execution(* com.example.herrdone.controller.*controller.*(..))")
    private void controllerCut(){ }

    @Before("controllerCut()")
    public void controllerLoggerAdvice(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();

        String typeName = signature.getDeclaringType().toString();
        String methodName = signature.getName();

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        System.out.println("\nrequest url : " + request.getServletPath() + "\ntype : " + typeName + "\nmethod : " + methodName + "\n");
        this.getLog().info(() -> StringsKt.trimIndent("\nrequest url : " + request.getServletPath() + "\ntype : " + typeName + "\nmethod : " + methodName + "\n"));
    }

    @AfterReturning(pointcut = "controllerCut()", returning = "result")
    public void controllerLogAfter(JoinPoint joinPoint, Object result){
    }
}
