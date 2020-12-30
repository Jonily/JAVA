package com.my.Diy;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//方式三使用注解方式实现AOP
@Aspect//标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.my.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("方法执行前");
    }
    @After("execution(* com.my.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("方法执行后");
    }

    //在环绕中，给定一个参数，代表要获取处理切入的点
    @Around("execution(* com.my.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");

        //执行方法
        Object p = jp.proceed();
        System.out.println("环绕后");



    }
}
