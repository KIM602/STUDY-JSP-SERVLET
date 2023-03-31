<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- java.sql패키지에 있는 필요한 클래스들 import -->
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%!
Connection connection;
Statement statement;
ResultSet resultSet;
//oracle driver경로
String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String uid = "scott";
String upw = "tiger";
String query = "select * from member";
%>
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

<h3>JDBC를 이용한 데이터베이스 처리</h3>
<%
try {
	Class.forName(driver); //oracle jdbc의 driver로 로드함(DriverManager클래스를 사용 가능)
	connection = DriverManager.getConnection(url, uid, upw);
	//oracle과 연결되는 connection객체
	statement = connection.createStatement();
	//sql문을 실행하는 메서드를 가진 객체
	resultSet =statement.executeQuery(query);
	//query는 sql문장 select * from member
	//executeQuery(query)는 select문을 수행하는 메서드로 ResultSet객체를 반환(다수개의 레코드 가짐)
	//executeUpdate(query)는 select이외의 DML(데이터조작명령, insert, update, delete)에서 사용, 정수값을 반환
	while(resultSet.next()) { //resultSet에 다음 원소가 있으면 true
		String id = resultSet.getNString("id");
		//DB의 컬럼이 문자열형(varchar2)이면 getString("db의 컬럼명")으로 값을 알아냄
		//만일 컬럼이 number이면 숫자타입에 따라 정수면 getInt("컬럼명")
		String pw = resultSet.getString("pw");
		String name = resultSet.getString("name");
		String phone = resultSet.getString("phone");
		out.println("아이디 : " + id + ", 비밀번호 : " + pw + ", 이름 : " + name + ", 전화번호 : " + phone + "<br />");
	}
}
catch(Exception e) {
	e.printStackTrace();
}
finally {
	try{
		if(resultSet != null)
			resultSet.close();
		if(statement != null)
			statement.close();
		if(connection != null)
			connection.close();
	}
	catch(Exception e1) {
		e1.printStackTrace();
	}
}
%>
</body>
</html>
