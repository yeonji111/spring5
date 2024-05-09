package org.example.aop;

import org.springframework.stereotype.Component;

@Component
public class Junghyun implements Student {
    @Override
    public void doSomething() {
        System.out.println("드라마를 본다.");
    }

}

