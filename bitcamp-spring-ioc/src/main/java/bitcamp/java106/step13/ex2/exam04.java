// AOP(Aspect-Oriented Programming) 적용 후
package bitcamp.java106.step13.ex2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// AOP?
// => 기존의 코드를 손대지 않고 특정 기능을 삽입하는 기술
// => 메서드 호출 앞뒤로 코드를 삽입할 수 있다.
// => 일종의 필터를 추가하는 기술이다.
//
// AOP 적용 방법
// => AOP 관련 의존 라이브러리 가져온다.
// => 필터 클래스를 정의한다.
// => XML 또는 자바 코드로 필터를 설정한다.
//
// AOP 용어
// => Advice        : 메서드(join point) 호출 앞뒤에 삽입될 코드이다. 필터 객체이다.
//                    예) MyAdvice
// => Join Point    : Advice가 들어갈 메서드이다.
//                    예) m() method
// => Pointcut      : Advice를 삽입할 위치정보이다.
//                    예) execution(* bitcamp.java106.step13.ex2.*.*(..))
// => Target Object : Advice를 삽입할 대상 객체이다.
//                    예) X, Y, C 클래스
// => Aspect        : 어느 pointcut에 어떤 advice를 삽입할 것인지 가리키는 정보이다.
//                    예) 설정 정보
public class exam04 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer =
                new ClassPathXmlApplicationContext(
                        "bitcamp/java106/step13/ex2/application-context-04.xml");
        
        String[] names = iocContainer.getBeanDefinitionNames();
        System.out.println("----------------------------------");
        for (String name : names) {
            System.out.println(iocContainer.getBean(name).getClass().getName());
        }
        System.out.println("----------------------------------");
        
        Caller caller = (Caller) iocContainer.getBean(Caller.class);
        caller.test();
    }

}