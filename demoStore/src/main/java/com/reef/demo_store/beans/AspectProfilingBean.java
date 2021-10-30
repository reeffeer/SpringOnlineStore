package com.reef.demo_store.beans;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//@Aspect
//@Component
//@Getter
public class AspectProfilingBean {
    Map<String, Long> timeMap;

    //    @PostConstruct
    private void init() {
        timeMap = new ConcurrentHashMap<>();
    }

    //    @Around("execution(public * ru.geekbrains.aprilmarket.controllers.*.*(..))")
    public Object methodProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        Long end = System.currentTimeMillis();
        Long duration = end - begin;
        timeMap.put(proceedingJoinPoint.getSignature().toString(), duration);
        return result;
    }
}
