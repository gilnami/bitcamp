// @RequestMapping - HTTP 요청에서 Content-Type 헤더 다루기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam04_4")
public class Exam04_4 {
    
    // HTTP 요청에서 "Content-Type" 헤더의 값에 따라 호출될 메서드를 구분하기
    // => 클라이언트는 POST 요청으로 데이터를 보낼 때
    //    서버에 그 데이터가 무슨 타입인지 알려줘야 한다.
    //    그 때 사용하는 헤더가 "Content-Type"이다.
    // 테스트 방법: 
    // 예) exam04_4.html
    
    //POST 요청
    /*
     * POST /spring-webmvc/mvc/exam04_4/get HTTP/1.1
     * HOST localhost:8888
     * Accept: ....
     * User-Agent: ....
     * Content-Type: application/x-www-form-urlencoded
     * 
     * name=aaa&age=20&tel=1111-2222&....
     */
    
    // 만약 클라이언트가 보낸 데이터가 "변수=값&변수=값&변수=값" 형태로 된 데이터라면?
    @PostMapping(value="post", consumes="application/x-www-form-urlencoded")
    @ResponseBody
    public String m1() {
        // 이 메서드는 실행한 결과를 순수한 텍스트로 만들어 보내야한다.
        return "Exam04_4.m1()";
    }
    
    // 만약 클라이언트가 보낸 데이터가 "값,값,값,값,값" 형태로 되어있다면?
    @PostMapping(value="post", consumes="text/csv")
    @ResponseBody
    public String m2() {
        // 이 메서드는 실행한 결과를 HTML 텍스트로 만들어 보내야 한다.
        return "Exam04_4.m2()";
    }
    
    // 만약 클라이언트가 보낸 데이터가 {"name":"aaa","age":20,"tel":"1111-2222"}형태로 되어있다면?
    @PostMapping(value="post", consumes="application/json")
    @ResponseBody
    public String m3() {
        // 이 메서드는 실행한 결과를 pdf로 보내야 한다.
        return "Exam04_4.m3()";
    }
}
