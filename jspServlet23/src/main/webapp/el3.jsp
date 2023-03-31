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
<title></title>
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

<h3>JSP 내부객체용 Form</h3>
<form action="objelOk.jsp" method="POST">
	아이디 : <input type="text" name="id" /><br />
	비밀번호 : <input type="password" name="pw" />
	<input type="submit" value="login" />
</form>

<%
//각각의 내부객체에 이름속성(내부객체명_name)과 값을 설정
//Scope객체가 참조하는 내부객체명 setAttribute("내부객체명_name", "값"), 값은 모든 객체가 가능
application.setAttribute("application_name","application_value");
session.setAttribute("session_name", "session_value");
pageContext.setAttribute("page_name", "page_value"); //page만 pageContext내부객체를 사용
request.setAttribute("request_name", "request_value");
//scope의 범위는 위에서 아래
%>
<hr />
<!-- 내부객체의 이름을 반환할 시는 해당내부객체의 scope객체를 이용한다. -->
pageScope : ${pageScope.page_name} <br /> <!-- 다른페이지에서는 사용 못함 -->
requestScope : ${requestScope.request_name} <br /> <!-- 다른 request에서는 사용 못함 -->
</body>
</html>
