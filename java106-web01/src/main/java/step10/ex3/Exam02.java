// 세션 : 값 꺼내기 
package step10.ex3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step10/ex3/exam02")
public class Exam02 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 1) 기존 세션 가져오기
        // => 주의!
        //    이 서블릿을 처음으로 실행하면 서버에 세션아이디를 보내지 않기 때문에
        //    서버 입장에서는 세션이 없는 것으로 간주하고 새로 세션을 만든다.
        // => 즉 세션이 없으면 새로 만든다.
        //    세션이 없다는 뜻은 웹브라우저가 세션 아이디를 알려주지 않았다는 뜻이다.
        HttpSession session = request.getSession();
        
        // 2)세션에 값 저장
        // => 서버쪽에 저장하는 것이기 때문에 어떤 값이라도 저장할 수 있다.
        //    즉 문자열 외에 숫자, 객체 모두 저장할 수 있다.
        session.setAttribute("s1", "aaa");
        session.setAttribute("s2", 200);// auto-boxing을 수행하여 객체로 변환한 후 저장된다.
        session.setAttribute("s3", new Date());
        
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("세션을 만들고 세션에 값으 저장했습니다.");
        out.println("그리고 세션의 아이디를 쿠키로 보냈습니다.");
        
        // 세션 생성
        // - getSession()을 호출하면,
        //   우선 웹브라우저가 보낸 쿠키 중에서 세션 아이디가 있는지 확인한다.
        //   만약 없다면 새 세션 객체(HttpSession)를 생성한 후 그 세션 객체를 리턴한다.
        // - 응답할 때 새로 생성한 세션 객체의 아이디를 웹브라우저로 쿠키에 담아 전달한다.
        //
        // HTTP 응답 프로토콜 예:
        /*
        HTTP/1.1 200
        Set-Cookie: JSESSIONID=45B8D7FAA6EF341D7E9E98B694F7CD17; Path=/java106-web01; HttpOnly
        Content-Type: text/plain;charset=utf-8
        Content-Length: 119
        Date: Wed, 23 May 2018 05:28:48 GMT
        */
    }
}
