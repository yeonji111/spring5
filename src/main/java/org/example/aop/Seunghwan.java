package org.example.aop;

import org.springframework.stereotype.Component;

@Component
public class Seunghwan implements Student {
    @Override
    public void doSomething() {
//        System.out.println("현관문을 열고 집에 들어온다.");

        System.out.println("GitHub를 본다.");

//        System.out.println("잠을 잔다.");
//        System.out.println("현관문을 닫고 집을 나온다.");
    }
}
