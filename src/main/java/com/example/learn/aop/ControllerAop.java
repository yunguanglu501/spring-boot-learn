package com.example.learn.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Aspect
@Slf4j
public class ControllerAop {

    @Pointcut("execution(public * com.example.learn.controller..*(..))")
    public void log() {

    }

//    @Before("log()")
//    public void doBefore(JoinPoint joinPoint) {
//        System.out.println("[AOP-log]：Before");
//    }
//
//    @After("log()")
//    public void doAfter(JoinPoint joinPoint) {
//        System.out.println("[AOP-log]：After");
//    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 请求参数
//        System.out.println("[AOP-log]：Around-请求参数=" + JSONObject.toJSONString(joinPoint.getArgs()));
        Signature signature = joinPoint.getSignature();
//        System.out.println("signature.getName() = " + signature.getName());
//        System.out.println("signature.getDeclaringType() = " + signature.getDeclaringType());
        log.info("controller:{},method:{},params:{}", signature.getDeclaringType(), signature.getName(), JSON.toJSONString(joinPoint.getArgs()));
        // 执行切面方法
        Object object = joinPoint.proceed();

        // 执行结果
        log.info("[AOP-log]：Around-执行结果:{}", JSONObject.toJSONString(object));
//        System.out.println("[AOP-log]：Around-执行结果=" + JSONObject.toJSONString(object));
//        System.out.println("[AOP-log]：Around-结束");
        return object;
    }

}