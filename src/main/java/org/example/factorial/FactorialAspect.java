package org.example.factorial;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FactorialAspect {
    // * : 모든
    // .. : 0개 이상
    @Around("execution(long org.example.factorial..*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();

        // 실제 factorial() 메소드 호출 부분
        Object result = joinPoint.proceed();
        
        long end = System.nanoTime();
        System.out.println("걸린 시간 :" +(end-start));
        return result;
    }
}
