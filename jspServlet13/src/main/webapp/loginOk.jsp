<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/> 
<title>JSP Login처리</title>
<!--bootstrap-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!--jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!--propper jquery -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!--latest javascript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!--fontawesome icon-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<!--google icon -->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
	
<!-- jsp에서는 form이나 param으로 오는 것은 getParameter로 값을 얻어 사용 -->

<%!
String id;
String pw;
%>
<%
id = request.getParameter("id"); //id는 input의 name속성값
pw = request.getParameter("pw");
if(id.equals("abcde") && pw.equals("12345")) { //로그인 성공처리
	Cookie cookie = new Cookie("id", id); //쿠키객체 생성, "id"는 쿠키이름, id는 값
	cookie.setMaxAge(60); //최대 유지시간(초)
	response.addCookie(cookie); //응답객체에 쿠키 실어보냄, 브라우저에서 저장
	response.sendRedirect("welcome.jsp");
}
else {
	response.sendRedirect("login.html");
}
%>
</body>
</html>
