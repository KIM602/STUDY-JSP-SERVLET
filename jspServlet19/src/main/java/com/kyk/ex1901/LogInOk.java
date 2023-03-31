package com.kyk.ex1901;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogInOk
 */
@WebServlet("/LogInOk")
public class LogInOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement stmt;
	private ResultSet resultSet; //select때는 필요
    
	private String name, id, pw, phone1, phone2, phone3, gender;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInOk() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			boolean flag = false;
			//form으로부터 오는 값
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			
			String query = "SELECT * FROM EXMEMBER19 WHERE ID = '" + id + "' AND PW = '" + pw + "'";
			//id가 primary key이므로 id와 password가 일치하는 것은 한개뿐이다.
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(query); //sql이 select문이므로 executeQuery(query)를 사용하고 반환은 ResultSet객체
				while (resultSet.next()) {
					flag = true;
					//db에서 resultSet으로 반환된 값의 컬럼
					name = resultSet.getString("name"); //resultSet의 문자열 컬럼값(varchar2)은 getString("컬럼명")
					id = resultSet.getString("id");
					pw = resultSet.getString("pw");
					phone1 = resultSet.getString("phone1");
					phone2 = resultSet.getString("phone2");
					phone3 = resultSet.getString("phone3");
					gender = resultSet.getString("gender");
				}
				
				if(flag) {
					HttpSession httpSession = request.getSession(); //session은 로그인부터 로그아웃까지 존재
					httpSession.setAttribute("name", name); //session명 name으로 변수 name값 저장
					httpSession.setAttribute("id", id); //session명 id로 변수 id값 저장
					httpSession.setAttribute("pw", pw); //session명 pw로 변수 pw값 저장
					response.sendRedirect("loginResult.jsp");
				}
				else {
					System.out.println("false");
					response.sendRedirect("login.html");
				}
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(resultSet != null)
							resultSet.close();
					if(stmt != null)
							stmt.close();
					if(connection != null)
							connection.close();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
	}

}
