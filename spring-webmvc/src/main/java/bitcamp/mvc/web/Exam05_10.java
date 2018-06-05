// 요청 핸들러의 파라미터 - @RequestPart를 사용하여 multipart/form-data 형식으로 넘어온 값 꺼내기
package bitcamp.mvc.web;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/exam05_10") 
public class Exam05_10 {
    
    // 멀티파트 형식으로 넘어온 데이터를 꺼낼 때는 기존의 파라미터 변수를 선언하는 방식과 같다.
    // 주의!
    // Spring WebMVC에 멀티파트 데이터를 처리하는 객체를 등록해야한다.
    // 또한 그 객체가 의존하는 아파치의 commons-fileupload 라이버르리도 추가해야한다.
    //
    // => 클라이언트가 멀티파트 형식으로 보낸 데이터를 처리하려면
    //    반드시 Spring WebMVC에 멀티파트 처리 담당자(객체)를 등록해야 한다.
    @Autowired ServletContext sc;
    
    @PostMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(
            String name, 
            int age, 
            MultipartFile photo) throws Exception{
            String filePath = sc.getRealPath("/" + photo.getOriginalFilename());
            photo.transferTo(new File(filePath));
            
            return String.format("m1(): name=%s, age=%d, photo=%s", 
                    name, 
                    age, 
                    photo.getOriginalFilename());
    }
}
