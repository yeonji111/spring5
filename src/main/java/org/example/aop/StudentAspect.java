package org.example.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// AOP 설정 파일이라고 스프링에게 알려주는 에노테이션

@Aspect
@Component
public class StudentAspect {

    // Before, After, Around 에노테이션에 중복되는 인자 작성을 방지하기위해 Pointcut 에노테이션을 사용
    // Advice에는 Pointcut의 메소드를 호출하기만 하면 된다.
    @Pointcut("execution(void org.example.aop.Student.doSomething())")
    public void studentTarget() {

    }

    @Before("studentTarget()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println("\n========= " + className + "님이 실행함 =========\n");
        System.out.println("현관문을 열고 집에 들어온다.");
    }

    @After("studentTarget()")
    public void after(JoinPoint joinPoint) {
        System.out.println("잠을 잔다.");
        System.out.println("현관문을 닫고 집을 나온다.");
    }

//    @AfterThrowing("execution(void org.example.aop.Student.doSomething())")
//    public void afterThrowing(JoinPoint joinPoint) {
//        System.out.println("119에 신고한다.");
//    }

    @Around("studentTarget()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        before(joinPoint);
        try {
            joinPoint.proceed();
        } catch (Exception e) {
            if (e.getMessage().equals("불이야!")) {
                System.out.println("119에 신고합니다.");
            }
        }
        after(joinPoint);
        return null;
    }
}

