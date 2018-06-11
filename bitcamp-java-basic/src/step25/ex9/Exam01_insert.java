// mybatis + spring IoC - 트랜잭션 컨트롤
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
        // 
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
                
        
        Board board = new Board();
        board.setContent("xxxx");

        board.setNo(141);
        board.setTitle("1111");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        board.setNo(142);
        board.setTitle("2222");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        board.setNo(141);
        board.setTitle("3333");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
    }
}







