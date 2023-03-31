<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %> <!-- Statement대신 사용 -->
<%@page import="java.sql.ResultSet" %>
<%!
Connection connection;
PreparedStatement preparedStatement;
ResultSet resultSet;

String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String uid = "scott";
String upw = "tiger";
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

<h3>PreapareStatement클래스 사용</h3>

<%
try {
	Class.forName(driver);
	connection = DriverManager.getConnection(url, uid, upw);
	int n = 0; //insert문 리턴값
	String query = "INSERT INTO MEMBER (id, pw, name, phone) VALUES(?,?,?,?)"; //PreparedStatement에서는 값을 ?로 사용
	preparedStatement = connection.prepareStatement(query); //값이 미지정된 preparedStatement객체 생성
	//preparedStatement에 값을 넣어줌
	preparedStatement.setString(1, "006"); //컬럼의 데이터형이 varchar2형인 경우 setString을 사용, 앞의 파라메터는 순서, 뒤는 값 id
	preparedStatement.setString(2, "123"); //pw
	preparedStatement.setString(3, "김길동"); //name
	preparedStatement.setString(4, "010-1234-5678"); //phone
	//sql이 insert이므로 executeUpdate()메서드를 사용
	n = preparedStatement.executeUpdate();
	
	preparedStatement.setString(1, "007");
	preparedStatement.setString(2, "456");
	preparedStatement.setString(3, "김길자");
	preparedStatement.setString(4, "010-8265-2418");
	n = preparedStatement.executeUpdate();
}
catch(Exception e) {
	e.printStackTrace();
}
finally {
	try {
		if(preparedStatement != null)
			preparedStatement.close();
		if(connection != null)
			connection.close();
	}
	catch(Exception e1) {
		e1.getMessage();
	}
}
%>
</body>
</html>
