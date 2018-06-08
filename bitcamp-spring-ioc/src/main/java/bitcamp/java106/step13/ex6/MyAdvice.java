package bitcamp.java106.step13.ex6;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    
    @Before("execution(* bitcamp.java106.step13.ex6.X.*(..)) and args(a,b)")
    public void doBefore(int a, int b) {
        System.out.printf("MyAdvice.doBefore(): %d, %d\n", a ,b);
    }
    
    @AfterReturning(
            pointcut="execution(* bitcamp.java106.step13.ex6.X.*(..))",
            returning="returnValue")
    public void doAfterReturning(Object returnValue) {
        System.out.printf("MyAdvice.doAfterReturning(): %s\n" , returnValue);
    }
    
    @AfterThrowing(
            pointcut="execution(* bitcamp.java106.step13.ex6.X.*(..))",
            throwing="error")
    public void doAfterThrowing(Exception error) {
        System.out.printf("MyAdvice.doAfterThrowing(): %s\n", error.getMessage());
    }
}
