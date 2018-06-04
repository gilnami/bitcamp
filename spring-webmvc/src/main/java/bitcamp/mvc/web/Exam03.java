// @RequestMapping - 한 클래스에 여러 개의 요청 핸들러 두기  II
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam03") // 클래스 선언부에는 상위 URL을 두고
public class Exam03 {
    
    // 각각의 RequestMapping 애노테이션에 하위 URL을 정의할 수 있다.
    @RequestMapping("m1")
    @ResponseBody
    public String m1() {
        return "Exam03.m1()";
    }
    
    @RequestMapping("m2")
    @ResponseBody
    public String m2() {
        return "Exam03.m2()";
    }
}
