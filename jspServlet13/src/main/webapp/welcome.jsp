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
<title>JSP</title>
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

<h3>쿠키값 알아내기</h3>

<%
Cookie[] cookies = request.getCookies();
//쿠키객체를 배열로 반환, 쿠키객체는 브라우저가 매 request마다 실어보냄
//쿠키는 기본 쿠키인 JSESSIONID이름으로 A1BF1A2F2DB4FA6D9554D38EB8918D5C과 같은 값을 갖는 쿠키를 갖고
//개발자가 만든 쿠키. 여기서는 쿠키이름을 id로 값은 abcde로 만듬
for(int i = 0 ; i < cookies.length ; i++) {
	String name = cookies[i].getName();
	out.println(name + "<br />");
	String id = cookies[i].getValue(); //쿠키의 값
	out.println(id + "<br />");
	if(id.equals("abcde")) {
		out.println(id + "님 안녕하세요." + "<br />");
	}
}
%>

<br />
<a href="logout.jsp">로그아웃</a>
<script>
$(document).ready(function(){
	alert(document.cookie);
	//클라이언트의 쿠키는 document객체의 cookie객체에 저장되며 이름은 서버에서 생성시 만든 이름으로 저장
	//내 request에 대한 쿠키만 저장
});
</script>
</body>
</html>
