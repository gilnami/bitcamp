// ApplicationContainer 구현체
package bitcamp.java106.pms;

import java.io.PrintWriter;
import java.io.StringWriter;

import bitcamp.java106.pms.context.ApplicationContext;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

public class DefaultApplicationContainer implements ApplicationContainer {
    
    ApplicationContext iocContainer;
    
    public DefaultApplicationContainer() throws Exception {
        //=> 컨트롤러, DAO 등 클라이언트 요청을 처리하는 객체를 자동 생성한다.
        iocContainer = new ApplicationContext("bitcamp.java106.pms");
    }
    
    @Override
    public String execute(String requestURI) {
        // 클라이언트가 보낸 데이터에서 명령어와 데이터를 분리하여 객체를 준비한다.
        ServerRequest request = new ServerRequest(requestURI);
        
        // 클라이언트 응답과 관련된 객체를 준비한다.
        StringWriter memoryWriter = new StringWriter();
        PrintWriter out = new PrintWriter(memoryWriter);
        
        ServerResponse response = new ServerResponse(out);
        
        // 클라이언트가 보낸 명령어를 처리할 컨트롤러를 찾는다.
        String path = request.getServerPath();
        Controller controller = (Controller) iocContainer.getBean(path);
        
        if (controller != null) {
            controller.service(request, response);
        } else {
            out.println("해당 명령을 처리할 수 없습니다.");
        }
        return memoryWriter.toString();
    }
}

//ver 29 - 클래스 추가
