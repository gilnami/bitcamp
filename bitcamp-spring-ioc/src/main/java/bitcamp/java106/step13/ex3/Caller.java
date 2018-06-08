package bitcamp.java106.step13.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Caller {
    @Autowired X x;
    
    public void test() {
        System.out.println("test()........시작");
        x.m1();
        System.out.println("test()........끝");
    }
}
