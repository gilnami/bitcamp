package com;
 
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.io.CachedOutputStream;
import org.json.simple.JSONObject;
 
/**
 * Servlet implementation class test
 */
@WebServlet("/PublicData.do")
public class PublicData extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicData() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
         
        String addr = "http://data.jeju.go.kr/rest/JejuLdapsDataService/getForecastPointDataXY?ServiceKey=";
        String serviceKey = "j2KT0WiQsYIQ1daSvlJI9F2%2Be0F0UW%2BacYymDWHHCX3BTq8ObPmb7WJSFxmIkLzxJDpIG%2BgjCRY1GqbWupOSlQ%3D%3D";
        String parameter = "";
//      serviceKey = URLEncoder.encode(serviceKey,"utf-8");
        PrintWriter out = response.getWriter();
        parameter = parameter + "&" + "areaCode=1";
        parameter = parameter + "&" + "eventStartDate=20170401";
        parameter = parameter + "&" + "eventEndDate=20171231";
        parameter = parameter + "&" + "pageNo=1&numOfRows=10";
        parameter = parameter + "&" + "MobileOS=ETC";
        parameter = parameter + "&" + "MobileApp=aa";
        parameter = parameter + "&" + "_type=json";
         
         
        addr = addr + serviceKey + parameter;
        URL url = new URL(addr);
         
        InputStream in = url.openStream(); 
        CachedOutputStream bos = new CachedOutputStream();
        IOUtils.copy(in, bos);
        in.close();
        bos.close();
         
//      out.println(addr);
         
        String data = bos.getOut().toString();      
        out.println(data);
         
        JSONObject json = new JSONObject();
        json.put("data", data);
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
         
        String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?ServiceKey=";
        String serviceKey = "429e9l%2BRPBvvMYSqI0TIu0JgvFl1vio2dcUfXj7d66%2F%2B2glco1EDs1HDHJBssw9U7HAt1A11Cy6N0Hbk2INDfQ%3D%3D";
        String parameter = "";
//      serviceKey = URLEncoder.encode(serviceKey,"utf-8");
        PrintWriter out = response.getWriter();
        parameter = parameter + "&" + "areaCode=1";
        parameter = parameter + "&" + "eventStartDate=20170401";
        parameter = parameter + "&" + "eventEndDate=20171231";
        parameter = parameter + "&" + "pageNo=1&numOfRows=10";
        parameter = parameter + "&" + "MobileOS=ETC";
        parameter = parameter + "&" + "MobileApp=aa";
        parameter = parameter + "&" + "_type=json";
         
         
        addr = addr + serviceKey + parameter;
        URL url = new URL(addr);
         
        InputStream in = url.openStream(); 
        CachedOutputStream bos = new CachedOutputStream();
        IOUtils.copy(in, bos);
        in.close();
        bos.close();
         
//      out.println(addr);
         
        String data = bos.getOut().toString();      
        out.println(data);
         
        JSONObject json = new JSONObject();
        json.put("data", data);
         
    }
}