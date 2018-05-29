// 프론트 컨트롤러 구현 
package bitcamp.java106.pms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
    
    ApplicationContext iocContainer;
    @Override
    public void init() throws ServletException {
        try {
            // 서블릿 컨테이너가 시작되면 스프링 IoC 컨테이너를 준비한다. 
            iocContainer = 
                    new ClassPathXmlApplicationContext(
                            getServletConfig().getInitParameter("contextConfigLocation"));
            
            // 서블릿에서 스프링 IoC 컨테이너를 꺼내 쓸 수 있도록,
            // WebApplicationContextUtils에 보관한다.
            WebApplicationContextUtils.containers.put(
                    this.getServletContext(), iocContainer);
            String[] beanName = iocContainer.getBeanDefinitionNames();
            for (String name : beanName) {
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // Front Controller
        // => 클라이언트의 모든 요청을 받아서 특정 컨트롤러에게 위임하기 전에 
        //    필요한 공통 기능 처리한다.
        // => 클라이언트의 진입점이 한 군데라서 유지보수가 용이하다.
        
        // 클라이언트가 요청한 서블릿의 경로를 알아내기
        String servletPath = request.getServletPath().replace(".do", "");
         
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher 요청배달자 = request.getRequestDispatcher(servletPath);
        요청배달자.include(request, response);   
        
        // 실제 작업을 수행한 컨트롤러가 알려준 JSP를 실행한다.
        String viewUrl = (String)request.getAttribute("viewUrl");
        if (viewUrl.startsWith("redirect:")) {
            response.sendRedirect(viewUrl.substring(9));
        } else {
            요청배달자 = request.getRequestDispatcher(viewUrl);
            요청배달자.include(request, response);
        }
    }
}

//ver 45 - 클래스 추가



