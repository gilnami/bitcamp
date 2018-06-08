// 인터셉터 - 페이지 컨트롤러를 실행하기 전후에 개입하기, 일종의 필터의 역할을 한다.
package bitcamp.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 인터셉터(interceptor)
// => Servlet의 Filter는 servlet 실행 전후에 개입하는 객체이다.
// =>interceptor는 pageController 실행 전후와 JSP 실행 전후에 개입하는 객체이다.
// => interceptor는 HandlerInterceptor를 구현해야 한다.
// => 배치 방법?
//   1) 자바 코드
//   2) XML : mvc-servlet.xml을 참고
// => 사용 예)
//    - 사용자 인증 또는 권한 검사
//    - log를 남길때 
//    - pageController를 실행하기 전에 client가 보낸 data를 암호 해제할 때
//    - client에게 보낼 data를 암호화시킬 때
//    - content의 암축 또는 해제

public class Exam09_1_interceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(
            HttpServletRequest request, 
            HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Exam09_1_interceptor.preHandler()");
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("Exam09_1_interceptor.postHandle()");
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("Exam09_1_interceptor.afterCompletion()");
    }
}







