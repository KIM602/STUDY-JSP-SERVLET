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
   //�������(�Ӽ�) ����
   private Connection connection;
   private Statement stmt;
   private String name, id, pw, phone1, phone2, phone3, gender; //join,html���� ���޹��� �����͸� ����(form���� ���� �����ʹ� ��� string)
       
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
      //post����� ���� �ѱ�ó��
      request.setCharacterEncoding("UTF-8");
      //Ŭ���̾�Ʈ Join.html�κ��� ��û�� �����͵��� request��ü�� ����
      //getPrameter("�Է¿��� name�Ӽ���")�� �Է°��� ���ϰ��̰� ��ȯ���� ���ڿ�
      //getParameterValues("�Է¿��� name�Ӽ���")�� checkboxó�� �Է°��� �������Ͻ� ��ȯ���� ���ڿ��迭
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
      //sql������ ���ڿ� ������ ' '�ȿ� �־��ش�.
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver"); //����Ŭ ����̹� �ε�
         connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott" , "tiger");
         stmt = connection.createStatement();
         int i = stmt.executeUpdate(query); //sql�� INSERT���̹Ƿ� executeUpdate(query)����ϰ� ��ȯ�� int��(������ 1, ���н� -1)
         if(i == 1) {
            System.out.println("insert success");
            response.sendRedirect("joinResult.jsp"); //������ �̵�
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