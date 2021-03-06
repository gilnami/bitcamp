// mybatis + spring IoC - @Transactional 애노테이션 적용 
package step25.ex10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {

    public static void main(String[] args) throws Exception {
        
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step25/ex10/application-context.xml");
        
        // 트렌젝션 적용
        // 1) @Transactional 애노테이션을 처리할 객체를 등록한다.
        //    => application-context.xml 파일에 객체 추가
        // 2) 트랜잭션을 적용할 대상 메서드에 애노테이션을 붙인다. 
        //    => BoardService의 메서드에 @Transactional 애노테이션을 붙인다.
        //
        BoardService boardService = iocContainer.getBean(BoardService.class);
                
        
        Board b1 = new Board();
        b1.setContent("xxxx");
        b1.setNo(171);
        b1.setTitle("1111");
        
        Board b2 = new Board();
        b2.setNo(172);
        b2.setTitle("2222");
        b1.setContent("xxxx");
        
        Board b3 = new Board();
        b3.setNo(171);
        b3.setTitle("3333");
        b1.setContent("xxxx");
        
        
        
        //boardService.test1(b1, b2, b3);
        boardService.test2(b1, b2, b3);
        
        System.out.println("입력 완료");
    }
}







