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

<h3>로그아웃시 쿠키 삭제</h3>
<%
Cookie[] cookies = request.getCookies();
if(cookies != null) {
	for(int i=0 ; i < cookies.length; i++) {
		if(cookies[i].getValue().equals("abcde")) {
			cookies[i].setMaxAge(0); //즉시 삭제시는 시간을 0초로
			response.addCookie(cookies[i]); //브라우저에서 쿠키를 삭제
		}
		//쿠키제거는 setMaxAge시간을 0으로 해주면 유효기간이 지난걸로 처리
		//삭제되는 cookie를 클라이언트로 보내주어야 클라이언트에서 cookie를 삭제
	}
}
%>

<script>
$(document).ready(function(){
	alert(document.cookie);
	//클라이언트의 쿠키는 document객체의 cookie객체에 저장되며 이름은 서버에서 생성시 만든 이름으로 저장
	//로그아웃시는 cookie가 없어 안보임
});
</script>
</body>
</html>
