package bitcamp.java106.step13.ex4;

import org.springframework.stereotype.Component;

@Component
public class X {
    public void m1() {
        System.out.println("X.m1()");
    }
    
    public int m1(int a, int b) {
        System.out.println("X.m1()");
        int result = a / b;
        
        return result;
    }
}
