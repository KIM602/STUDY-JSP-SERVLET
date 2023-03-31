package com.kim.ex0801;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SContext
 */
@WebServlet("/SCT")
public class SContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SContext() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		String id = this.getServletContext().getInitParameter("id");
		//getServletContext()�޼���� HttpServletŬ������ ����� ���� ����� ���������� ����� �� �ִ� �޼���� ��ȯ�� ServletContext��ü�� ��ȯ��
		//ServletContext�� getInitParameter("id")�� web.xml�� ������ id�Ķ���Ͱ��� ������
		String pw = getServletContext().getInitParameter("pw");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("���̵� : " + id + "<br/>");
		writer.println("��й�ȣ : " + pw + "<br/>");
		writer.println("</body></html>");
		
		writer.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //post��� ���� �ѱ� ó��
		doGet(request, response);
	}

}
