<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

<h3>JSTL CORE</h3>
<h4>c:out</h4>
<c:out value="10"></c:out><br /> <!-- 인라인으로 표시되므로 br줌 -->
<c:out value="20"></c:out><br />
<c:out value="${age}" default="값이 없습니다."/><br />
<c:out value="${age}" escapeXml="true">값이 없습니다.</c:out><br />
<c:out value="<html>"></c:out><br />
<c:out value="<html>" escapeXml="false"></c:out><br />
<!-- c:out은 value값을 클릭하며 value에 EL문으로 변수를 사용시 변수가 없으면 default값을 출력 -->
<!-- default가 없는 대신 내용에 문장을 넣으면 default처럼 동작 -->
<!-- 변수값은 EL문을 사용하여 지정 -->
<!-- excapeXml속성은 true일 때 태그표시 <,>를 엔터티처럼 처리하고 false는 변환하여 처리 -->
<!-- escapeXml속성은 기본이 true임 -->
<h4>c:set</h4>
<c:set var="varName" value="varValue"></c:set>
<c:out value="${varName}"></c:out>
<h4>변수제거</h4>
<c:remove var="varName"/> <!-- var에 제거할 변수명 -->

<p>제거 후 출력</p>
varName : <c:out value="${varName}"/><br />

<h4>예외 처리</h4>
<c:catch var="error"><%= 2/0 %></c:catch>
<!-- var은 예외내용 저장변수이고 내용부분에 예외발생 가능문 작성 -->
<p>예외내용 : <c:out value="${error}"/></p>

<h4>if처리 태그</h4>
<!-- if문의 조건처리는 관계연산이나 논리연산으로 처리하므로 el의 연산처리를 사용 -->
<!-- 결과가 true이면 내용부분으로 들어가고 (즉, 자바나 js의 { }) false이면 못들어감 -->
<c:if test="${1 + 2 == 3}" var="result">결과는 3입니다.</c:if><br />
<c:if test="${1 + 2 != 3}">결과는 3이 아닙니다.</c:if><br /> <!-- 결과가 false이므로 내용 부분은 못들어감 -->

<h4>다중조건처리(if else if else 또는 switch)</h4>
<c:set var="name" value="홍길동"/><br />
<c:choose>
	<c:when test="${name == '철수'}">
		철수 입니다.
	</c:when>
	<c:when test="${name == '홍길동'}">
		홍길동 입니다.
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
<!-- jstl에서는 문자열 비교에서도 ==이 동작 -->
<!-- ==은 eq, !=은 ne, 값이 없을 때는 empty를 사용 -->
<hr />
<!-- param내부객체는 form의 입력원소 -->
<c:choose>
	<c:when test="${empty param.name}">
		<form>
			이름 : <input type="text" name="name"/>
			<input type="submit" value="확인" />
		</form>
	</c:when>
	<c:when test="${param.name eq 'admin'}">
		관리자 작업
	</c:when>
	<c:when test="${param.name eq 'user'}">
		일반 사용자. 회원 <c:out value="${param.name}"/>
	</c:when>
</c:choose>

<h4>items속성이 없는 반복처리 forEach 태그</h4>
<!-- var속성은 자바에서 반복변수 i역할, step은 증감 속성 -->
<c:forEach var="fEach" begin="0" end="30" step="3">
	${fEach}&nbsp;
</c:forEach>

<h4>items속성이 있는 배열 형식의 반복</h4>
<!-- 배열 선언 -->
<c:set var="arr" value="<%=new int[]{1,2,3,4,5} %>"></c:set>
<!-- items속성은 배열객체의 값, var속성은 배열객체의 원소를 나타내는 변수 -->
<c:forEach items="${arr}" var="i">
	${i}&nbsp;
</c:forEach>
<hr />

</body>
</html>
