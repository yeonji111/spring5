package org.example.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentExample {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(StudentApplicationContext.class);

        Student gunhee = context.getBean("gunhee", Student.class);
        gunhee.doSomething();

        Student junghyun = context.getBean("junghyun", Student.class);
        junghyun.doSomething();

        Student yongseok = context.getBean("yongseok", Student.class);
        yongseok.doSomething();

        Student seunghwan = context.getBean("seunghwan", Student.class);
        seunghwan.doSomething();
    }
}
