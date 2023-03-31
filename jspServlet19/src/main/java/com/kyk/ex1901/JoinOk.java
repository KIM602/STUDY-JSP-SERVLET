package com.kyk.ex1901;

import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class JoinOk
 */
@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
   private static final long serialVersionUID = 1L;
   //멤버변수(속성) 정의
   private Connection connection;
   private Statement stmt;
   private String name, id, pw, phone1, phone2, phone3, gender; //join,html에서 전달받은 데이터를 정의(form으로 받은 데이터는 모두 string)
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
        super();
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //response.getWriter().append("Served at: ").append(request.getContextPath());
      System.out.println("doGet");
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
      //post방식을 위해 한글처리
      request.setCharacterEncoding("UTF-8");
      //클라이언트 Join.html로부터 요청시 데이터들은 request객체에 있음
      //getPrameter("입력원소 name속성값")은 입력값이 단일값이고 반환값은 문자열
      //getParameterValues("입력원소 name속성값")은 checkbox처럼 입력값이 복수개일시 반환값은 문자열배열
      name = request.getParameter("name");
      id = request.getParameter("id");
      pw = request.getParameter("pw");
      phone1 = request.getParameter("phone1");
      phone2 = request.getParameter("phone2");
      phone3 = request.getParameter("phone3");
      gender = request.getParameter("gender");
      
      //String query = "INSERT INTO EXMEMBER19 VALUES(id, pw, name, phone1, phone2, phone3, gender)";
      String query = "insert into EXMEMBER19 values"
                        + "('" + id + "', '" + pw + "', '" + name + "', '" + phone1 + "', '" + phone2 + "', '" + phone3 + "', '" + gender + "')";
      //sql에서는 문자열 값에는 ' '안에 넣어준다.
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클 드라이버 로드
         connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott" , "tiger");
         stmt = connection.createStatement();
         int i = stmt.executeUpdate(query); //sql이 INSERT문이므로 executeUpdate(query)사용하고 반환은 int값(성공은 1, 실패시 -1)
         if(i == 1) {
            System.out.println("insert success");
            response.sendRedirect("joinResult.jsp"); //페이지 이동
         }
         else { 
            System.out.println("insert fail");
            response.sendRedirect("join.html");
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
}