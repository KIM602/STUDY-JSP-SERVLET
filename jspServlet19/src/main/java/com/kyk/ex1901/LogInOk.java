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
	private ResultSet resultSet; //select���� �ʿ�
    
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
			//form���κ��� ���� ��
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			
			String query = "SELECT * FROM EXMEMBER19 WHERE ID = '" + id + "' AND PW = '" + pw + "'";
			//id�� primary key�̹Ƿ� id�� password�� ��ġ�ϴ� ���� �Ѱ����̴�.
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(query); //sql�� select���̹Ƿ� executeQuery(query)�� ����ϰ� ��ȯ�� ResultSet��ü
				while (resultSet.next()) {
					flag = true;
					//db���� resultSet���� ��ȯ�� ���� �÷�
					name = resultSet.getString("name"); //resultSet�� ���ڿ� �÷���(varchar2)�� getString("�÷���")
					id = resultSet.getString("id");
					pw = resultSet.getString("pw");
					phone1 = resultSet.getString("phone1");
					phone2 = resultSet.getString("phone2");
					phone3 = resultSet.getString("phone3");
					gender = resultSet.getString("gender");
				}
				
				if(flag) {
					HttpSession httpSession = request.getSession(); //session�� �α��κ��� �α׾ƿ����� ����
					httpSession.setAttribute("name", name); //session�� name���� ���� name�� ����
					httpSession.setAttribute("id", id); //session�� id�� ���� id�� ����
					httpSession.setAttribute("pw", pw); //session�� pw�� ���� pw�� ����
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
