// 웹 애플리케이션 컴포넌트 : FilterConfig의 활용
package step09.ex1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 애노테이션 대신에 web.xml에 배치정보를 설정한다.
// @WebFilter("/step09/ex1/exam02")
public class Filter3 implements Filter{
    FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        System.out.println("Filter2.init()");
    }
    
    @Override
    public void destroy() {
        System.out.println("Filter2.destroy()");
    }
    
    @Override
    public void doFilter(
            ServletRequest request, 
            ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // FilterConfig
        chain.doFilter(request, response);
    
    }
}
