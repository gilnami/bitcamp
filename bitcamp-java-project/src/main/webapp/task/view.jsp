<%@page import="bitcamp.java106.pms.domain.Task"%>
<%@page import="bitcamp.java106.pms.domain.Member"%>
<%@page import="bitcamp.java106.pms.domain.Team"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>작업 보기</title>
</head>
<body>
<div id='header'>
 <a href='/bitcamp-java-project/auth/login'>로그인</a></div>
<h1>작업 보기</h1>
<%
Task task = (Task) request.getAttribute("task");
%>
<form action='update' method='post'>
<input type='hidden' name='no' value='13'>
<table border='1'>
<tr>
    <th>팀명</th><td><input type='text' name='teamName' value='t1' readOnly></td>
</tr>
<tr>
    <th>작업명</th><td><input type='text' name='title' value='11'></td>
</tr>
<tr>
    <th>시작일</th><td><input type='date' name='startDate' value='2018-04-30'></td></tr>
<tr>
    <th>종료일</th><td><input type='date' name='endDate' value='2018-05-08'></td></tr>
<tr>
    <th>작업자</th>
    <td>
        <select name='memberId'>
            <option value=''>--선택 안함--</option>
            <option selected>aaa</option>
        </select>
    </td>
</tr>
<tr>
    <th>작업상태</th><td><select name='state'>
        <option value='0' selected>작업대기</option>
        <option value='1' >작업중</option>
        <option value='9' >작업완료</option>
    </select></td>
</tr>
</table>
<button>변경</button> 
<a href='delete?no=13&teamName=t1'>삭제</a>
</form>
</body>
</html>
