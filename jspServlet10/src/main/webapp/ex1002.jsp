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
<title>jsp 선언 태그</title>
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

<div class="container">
	<h3>jsp 선언 태그</h3>
	<hr/>
	<!-- 선언태그는 %!태그이다 -->
	<%!
		int i = 10; //변수 선언 (선언태그 안에서 선언된 변수는 전역변수)
		String str = "ABCDE";
	%>
	<%!
	//메서드 선언
		public int sum(int a, int b) {
			return a+b;
	}
	%>
	
	<!-- scriptlet으로 선언된 변수와 메서드 사용 -->
	<%
		out.println("i = " + i + "<br/>"); //변수 출력
		out.println("str = " + str + "<br/>");
		out.println("sum = " + sum(1,5) + "<br/>"); //메서드 호출
	%>
</div>
</body>
</html>
