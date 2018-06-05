// 요청 핸들러의 리턴 값 - 콘텐트를 직접 리턴하기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam06_1") 
public class Exam06_1 {
    
    // request handler에서 콘텐트를 직접 리턴할 때는
    // 메서드 선언부에 @ResponseBody를 붙여야 한다.
    @GetMapping(value="m1")  
    @ResponseBody  
    public String m1() {
        // 응답 콘텐트의 타입은 기본으로
        // "text/html;charset=ISO-8859-1"이다.
        // 따라서 한글을 출력할때 ?문자로 바뀌어 출력된다.
        return "Exam06_1.m1() ==> 012ABCabc#@!가각간";
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")  
    @ResponseBody  
    public String m2() {
        // @ResponseBody로 콘텐트를 출력할 떄
        // Content-Type을 설정하고 싶다면,
        // @RequestMapping,@GetMapping,@PostMapping 애노테이션에서
        // produces 속성에 콘텐트 타입을 지정하라
        return "Exam06_1.m2() ==> 012ABCabc#@!가각간";
    }
}







