<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam02</title>
</head>
<body>
<h1>EL에서 저장소를 사용하는 방법 II</h1>
<pre>
저장소의 이름을 생샥하면 다음 순서로 값을 찾는다.

    PageConext ==> ServletRequest ==> HttpSession ==> ServletContext
</pre>
<%
// JSP에서 저장소 객체를 사용하려면 pageContext, request, session, application 이름으로 된
// 객체를 사용해야 한다.
pageContext.setAttribute("tel", "1111");
request.setAttribute("tel", "2222");
session.setAttribute("tel", "3333");
application.setAttribute("tel", "4444");
%>
tel: ${tel} <br>

</body>
</html>