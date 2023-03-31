<%@page import="com.kyk.ex2001.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kyk.ex2001.MemberDAO"%>
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

<h3>DAO,DTO클래스 사용</h3>

<%
MemberDAO memberDAO = new MemberDAO(); //JDBC사용
ArrayList<MemberDTO> dtos = memberDAO.memberSelect();
for(int i =0; i < dtos.size(); i++) {
	MemberDTO dto = dtos.get(i); //ArrayList의 get(인덱스번호)메서드는 인덱스의 원소를 반환, MemberDTO객체 반환
	//DTO의 get메서드로 멤버변수값 반환
	String name = dto.getName();
	String id = dto.getId();
	String pw = dto.getPw();
	String phone = dto.getPhone();
	out.println("이름 : " + name + ", 아이디 : " + id + ", 비밀번호 : " + pw + ", 연락처 : " + phone + "<br />");
}
%>

</body>
</html>
