// ServletRequestAttributeListener
package step09.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step09/ex2/exam01")
public class Exam01 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 파라미터로 받은 값을 ServletRequest에 저장해보자!
        // 1) 파라미터 값을 꺼낸다.
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        
        // 2) ServletRequest에 저장한다.
        request.setAttribute("이름", name);
        request.setAttribute("나이", age);
        System.out.println("-----------------------------");
        
        // 3) ServletRequest에 저장된 값을 변경
        request.setAttribute("이름", "우하하");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>exam01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>exam01 실행!</h1>\n");
        out.println("</body>");
        out.println("</html>");
        
        // 콘솔 창에 서블릿이 실행 되었음을 표시하기 위해
        // => 필터의 실행화 서블릿의 실행 순서를 확인하기 위함
        System.out.println("/step09/ex1/exam01 실행!");
        
    }
}







