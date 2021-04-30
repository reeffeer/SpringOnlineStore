package my.project.armorer.s.shop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* my.project.armorer.s.shop.services..*.*(..))")
    public void findById() {
    }

    @After("findById()")
    public void logAfter() {
        System.out.println("Поиск завершен.");
    }
}
