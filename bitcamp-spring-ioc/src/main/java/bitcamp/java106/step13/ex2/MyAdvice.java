// 특정 method 호출 전후에 실행되는 class
package bitcamp.java106.step13.ex2;

public class MyAdvice {
    // 삽입될 method를 정의한다.
    public void advice1() {
        System.out.println("MyAdvice.advice1()");
    }
    
    public void advice2() {
        System.out.println("MyAdvice.advice2()");
    }
}
