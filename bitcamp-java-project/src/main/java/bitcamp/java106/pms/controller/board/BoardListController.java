package bitcamp.java106.pms.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;

@Component("/board/list")
public class BoardListController implements PageController{
    
    BoardDao boardDao;
    
    public BoardListController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @Override
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
            // JSP에서 출력할 게시물 목록을 가져온다.
            List<Board> list = boardDao.selectList();
            
            // JSP가 게시물 목록을 사용할 수 있도록 ServletRequest 보관소에 저장한다.
            request.setAttribute("list", list);
            
            return "/board/list.jsp";
    }
}

//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 39 - forward 적용
//ver 37 - BoardListController를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 list() 메서드를 추출하여 클래스로 정의. 
