// 세션 다루기 - http세션에 보관된 데이터 꺼내기
package bitcamp.mvc.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller 
@RequestMapping("/exam08_4") 
@SessionAttributes({"name","age","working"})
// 세션의 값을 @ModelAttribute를 사용하여 꺼내려면
// @SessionAttributes 애노테이션은 요청 핸들러에서 세션의 값을 꺼낼 때에도
public class Exam08_4 {
    
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")  
    @ResponseBody
    public String m1(
            // 만약 세션에 보관된 값이 없으면 오류!
            @ModelAttribute("name") String name,
            @ModelAttribute("age") int age,
            @ModelAttribute("working") boolean working
            ) {
        return String.format("m1(): @ModelAttribute로 세션 값 꺼내기 - name=%s, age=%d, working=%b",
                name, age, working);
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")  
    @ResponseBody
    public String m2(
            SessionStatus status
            ) {
        // SessionStatus로 세션에 보관된 값 없애기
        status.setComplete();
        return String.format("m2(): SessionStatus로 세션에 보관된 값 없애기");
    }
}







