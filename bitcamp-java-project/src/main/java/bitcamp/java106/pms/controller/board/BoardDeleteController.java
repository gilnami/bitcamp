package bitcamp.java106.pms.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@Component("/board/delete")
public class BoardDeleteController implements PageController {
    
    BoardDao boardDao;
    
    public BoardDeleteController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    @Override
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
            int no = Integer.parseInt(request.getParameter("no"));
            int count = boardDao.delete(no);
            if (count == 0) {
                throw new Exception("해당 게시물이 없습니다.");
            }
            return "redirect:list.do";
    }
    
}

//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - BoardDeleteController를 서블릿으로 변경
//         결과를 HTML로 출력
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 delete() 메서드를 추출하여 클래스로 정의. 
