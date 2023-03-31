<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="Student" class="com.kyk.jspServlet16.Student" scope="page"/>
<!-- id속성은 jsp내에서의 객체 이름(빈이름), class속성은 사용할 bean클래스, scope는 사용 범위 -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- MS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8,IE=EmulateIE9"/> 
<title>JSP Bean사용</title>
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

<h3>bean관련 액션태그 사용</h3>
<jsp:setProperty property="name" name="Student" value="홍길동"/>
<!-- name속성은 id로 지정된 빈 이름, property는 속성(멤버변수)를 나타냄, value는 설정값 -->
<!-- 설정하는 방식은 실제로 Student클래스의 해당 멤버변수 set메서드를 호출 -->
<!-- jsp에서는 value의 값은 모두 문자열로 처리 -->
<jsp:setProperty property="age" name="Student" value="13"/>
<jsp:setProperty property="grade" name="Student" value="6"/>
<jsp:setProperty property="studentNum" name="Student" value="7"/>

<!-- jsp:getProperty에선 태그는 반환받은 값을 그 위치에 출력 -->
<!-- 실제로는 Student클래스의 해당 멤버변수의 get메서드를 호출 -->
<h3>이름 : <jsp:getProperty property="name" name="Student"/></h3>
나이 : <jsp:getProperty property="age" name="Student"/><br />
학년 : <jsp:getProperty property="grade" name="Student" /><br />
번호 : <jsp:getProperty property="studentNum" name="Student" /><br />
</body>
</html>
