package org.example.factorial;

import org.example.aop.StudentApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactorialExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(FactorialApplicationContext.class);
        // 반복문으로 팩토리얼 구했을 시 걸리는 시간 : 700ns
        Calculator forLoop = context.getBean("forLoop",Calculator.class);
        long result = forLoop.factorial(10);
        System.out.println("for loop : " +result);

        // 재귀함수를 사용해서 팩토리얼을 구했을 시 걸리는 시간 : 1700ns
        Calculator recursive = context.getBean("recursive",Calculator.class);
        result = recursive.factorial(10);
        System.out.println("recursive : " +result);
    }
}
