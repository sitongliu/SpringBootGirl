package com.sitong.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiuSitong on 2017/3/19.
 */
@Aspect
@Component
public class HttpAspect {
    //日志
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * com.sitong.controller.GirlController.*(..))")
    public void log(){
        logger.info("0000000000");
    }


    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
      //  logger.info("111111111111111111");
        //记录http请求
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
      logger.info("url={}",request.getRequestURL());
      //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip= {}",request.getRemoteAddr());
        //类方法
        logger.info("classMethod={}",
                joinPoint.getSignature().getDeclaringTypeName()+"."+ joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }


    @After("log()")
    public void doAfter(){
        System.out.println("2222222");
    }

    //控制台输出查询到的值
    @AfterReturning(returning = "o" ,pointcut = "log()")
    public void doAfterReturning(Object o){
        logger.info("response={}",o.toString());
    }

}
