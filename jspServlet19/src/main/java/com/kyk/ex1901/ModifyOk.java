package com.kyk.ex1901;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyOk
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;
    private Statement stmt;
    private String name, id, pw, phone1, phone2, phone3, gender;
    HttpSession httpSession;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyOk() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		request.setCharacterEncoding("UTF-8");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		httpSession = request.getSession();
		id = (String)httpSession.getAttribute("id"); //세션에 입력한 ID값을 가져옴 
		//modify.jsp의 form에서수정한 값을 파라메터에서 얻어냄
		name = request.getParameter("name");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		if(pwConfirm()) {
			String query = "update exmember19 set name = '" +name + "', phone1='" + phone1 +
					"', phone2 = '" + phone2 + "', phone3 = '" + phone3 + "',  gender = '" + gender + "' where id = '" + id + "'";
			System.out.println("true");
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				stmt = connection.createStatement();
				int i = stmt.executeUpdate(query); //sql이 update문이므로 excuteUpdate()이고 성공시 1반환
				System.out.println("i값은 ="+i);
				System.out.println(query);
				if(i == 1) {
					System.out.println("update success");
					httpSession.setAttribute("name", name);
					response.sendRedirect("modifyResult.jsp");
				}
				else {
					System.out.println("update fail");
					response.sendRedirect("modify.jsp");
				}
			}
			catch(Exception e) {
				 e.printStackTrace();
			}
			finally {
				try {
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
		else {
			System.out.println("비번이 틀려 수정 불가");
		}
}
	
	private boolean pwConfirm() {
		boolean rs = false;
		String sessionPw = (String)httpSession.getAttribute("pw"); //session에 저장한 pw
	
		if(sessionPw.equals(pw)) { //session의 pw와 modify.jsp form의 pw를 비교
			rs = true;
		}
		else {
			rs = false;
		}
		
		return rs;
	}
}
