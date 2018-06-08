// AOP(Aspect-Oriented Programming) - AOP filter 적용 위치
package bitcamp.java106.step13.ex3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class exam01 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer =
                new ClassPathXmlApplicationContext(
                        "bitcamp/java106/step13/ex3/application-context-01.xml");
        
        String[] names = iocContainer.getBeanDefinitionNames();
        System.out.println("----------------------------------");
        for (String name : names) {
            System.out.println(iocContainer.getBean(name).getClass().getName());
        }
        System.out.println("----------------------------------");
        
        try {
            Caller caller = (Caller) iocContainer.getBean(Caller.class);
            caller.test();
        } catch (Exception e) {
            System.err.println("오류 발생");
        }
    }

}
