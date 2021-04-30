package my.project.armorer.s.shop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class BadAspect {

    @AfterReturning(pointcut = "execution(public * my.project.armorer.s.shop.entities.Cart.calculate(..))",
            returning = "result")
    public int cartCalculate(JoinPoint joinPoint, int result) {
        BigDecimal totalPrice = new BigDecimal(1000);
        result = 300;
        totalPrice = BigDecimal.valueOf(result);
        return result;
    }

}
