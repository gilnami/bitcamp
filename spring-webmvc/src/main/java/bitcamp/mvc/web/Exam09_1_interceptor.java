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







