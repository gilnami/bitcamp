package bitcamp.java106.step13.ex4;


public class MyAdvice {

    public void doBefore() {
        System.out.println("MyAdvice.doBefore()");
    }
    
    public void doAfter() {
        System.out.println("MyAdvice.doAfter()");
    }
    
    public void doAfterReturning() {
        System.out.println("MyAdvice.doAfterReturning()");
    }
    
    public void doAfterThrowing() {
        System.out.println("MyAdvice.doAfterThrowing()");
    }
    
    public void doAround() {
        System.out.println("MyAdvice.doAround()");
    }
}
