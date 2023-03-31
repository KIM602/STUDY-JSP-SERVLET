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
<h3>form에서 오는 파라메터 처리 내부객체 param</h3>
<%!
String id,pw;
%>

<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
%>

<h3>expression으로 출력</h3>
아이디 : <%= id %> <br />
비밀번호 : <%= pw %> <br />

<!-- param 내장객체를 사용한 방법 이때는 EL방식을 사용 가능 -->
<h3>param과 EL로 출력</h3>

아이디 : ${param.id} <br />
비밀번호 : ${param.pw} <br />

<!-- EL안에서 사용하기 위해서는 xxxScope내장객체를 사용하여 xxx객체의 값을 구함 -->
application : ${applicationScope.application_name} <br />
session : ${sessionScope.session_name} <br />

context 초기화 파라미터 <br /> <!-- web.xml에서 설정 -->
<!-- initParam 내장객체를 사용 -->
<h3>initParam과 EL로 출력</h3>
${initParam.con_name} <br />
${initParam.con_id} <br />
${initParam.con_pw} <br />
</body>
</html>
