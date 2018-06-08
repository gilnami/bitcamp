// Spring IoC Container를 설정하는 class
package bitcamp.java106.step13.ex6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 이 class가 설정 class임을 선언한다.
@ComponentScan("bitcamp.java106.step13.ex6")
@EnableAspectJAutoProxy
public class AppConfig {

}
