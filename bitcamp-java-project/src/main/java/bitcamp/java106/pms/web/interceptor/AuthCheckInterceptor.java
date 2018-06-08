// login 여부를 검사하는 interceptor - login 사용자만 service를 사용하게 한다.
package bitcamp.java106.pms.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import bitcamp.java106.pms.domain.Member;

public class AuthCheckInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(
            HttpServletRequest request, 
            HttpServletResponse response, Object handler)
            throws Exception {
        
        HttpSession session = request.getSession();
        Member loginUser= (Member) session.getAttribute("loginUser");
        if (loginUser == null) { // login을 하지 않았으면 login form으로 보낸다.
            response.sendRedirect(request.getContextPath() + "/app/auth/form");
            return false;
        }
        // login 했으면 다음 interceptor로 이동
        return true;
    }
}
