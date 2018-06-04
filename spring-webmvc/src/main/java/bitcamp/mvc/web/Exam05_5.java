// 요청 핸들러의 파라미터 - custom property editor 등록하기 II
package bitcamp.mvc.web;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam05_5")
public class Exam05_5 {

    // 프론트 컨트롤러가 페이지 컨트롤러를 호출할 때 기본적으로 
    // 클라이언트가 보낸 문자열 데이터를 primitive type의 값으로 변환시켜 준다.
    // 그 외의 타입에 대해서는 개발자가 프로퍼티 값 변환기(property editor)를 등록해야 한다.
    // 테스트:
    // http://localhost:8888/spring-webmvc/mvc/exam05_4/m1?title=aaaa&content=bbbb&createdDate=2018-06-04
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(String title, String content, Date createdDate) {
        return String.format("m1():%s, %s, %s", 
                title, content, createdDate);
    }
    // 글로벌 컨트롤러 어드바이스 객체에 따로 프로퍼티 에디터를 초기화시키는 메서드를 정의해 두었기 때문에
    // 다음 메서드를 이 컨트롤러에 등록하지 않아도 된다.
/*    
 * @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                Date.class,
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        super.setValue(Date.valueOf(text));
                    }
                });
    }*/
}
