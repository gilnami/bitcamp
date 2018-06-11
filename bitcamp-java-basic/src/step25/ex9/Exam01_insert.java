// mybatis + spring IoC - 트랜잭션 적용 후 
package step25.ex9;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {

    public static void main(String[] args) throws Exception {
        
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step25/ex9/application-context.xml");
        
        // 트랜잭션 관리자를 도입하지 않으면,
        // DAO의 각 메서드 호출은 독립작업으로 간주한다.
        // 즉 DAO 메서드를 호출할 때마다
        // DataSource로 부터 별도의 DB 커넥션을 받아서 사용한다.
        // 따라서 DAO 메서드를 호출하다가 오류가 발생하더라도,
        // 그 전에 호출한 메서드의 작업은 그대로 DB 테이블에 적용된다.
        
        // 트렌젝션 적용
        // 1) 트랜잭션 관리자를 등록해야한다.
        //    => application-context.xml 파일에 객체 추가
        // 2) 트랜잭션 관리자가 동작하려면 DAO를 사용하는 객체도 
        //    트랜잭션 관리자와 같은 컨테이너에 객체가 있어야한다.
        //    즉 DAO의 메서드를 사용하는 객체 또한 SpringIoC 컨테이너에 있어야한다.
        //    => DAO 메서드를 호출하는 Service 객체를 만든다.
        //    => BoardService 추가
        // 3) AOP를 사용하여 트랜잭션 관리자를 적용한다.
        //    => application-context.xml에 AOP Advice와 PointCut을 실행한다.
        BoardService boardService = iocContainer.getBean(BoardService.class);
                
        
        Board b1 = new Board();
        b1.setContent("xxxx");
        b1.setNo(161);
        b1.setTitle("1111");
        
        Board b2 = new Board();
        b2.setNo(162);
        b2.setTitle("2222");
        b1.setContent("xxxx");
        
        Board b3 = new Board();
        b3.setNo(161);
        b3.setTitle("3333");
        b1.setContent("xxxx");
        
        
        
        boardService.test1(b1, b2, b3);
        boardService.test2(b1, b2, b3);
        
        System.out.println("입력 완료");
    }
}







