package bitcamp.java106.step13.ex5;


public class MyAdvice {
    
    // Target 객체의 method를 호출하기 전에 그 method가 받을 parameter를 먼저 받기
    public void doBefore(int a, int b) {
        System.out.printf("MyAdvice.doBefore(): %d, %d\n", a ,b);
    }
    
    public void doAfterReturning(Object returnValue) {
        System.out.printf("MyAdvice.doAfterReturning(): %s\n" , returnValue);
    }
    
    public void doAfterThrowing(Exception error) {
        System.out.printf("MyAdvice.doAfterThrowing(): %s\n", error.getMessage());
    }
}
