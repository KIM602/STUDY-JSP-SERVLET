package com.kim.ex0801;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInit
 */

public class ServletInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		//web.xml���� ������ �Ķ���ʹ� GET������� ���޵�
		String id = this.getInitParameter("id");
		//getInitParameter("name")�� HttpServlet�� �޼����̹Ƿ� ���� ���� ���� Ŭ������ �ν��Ͻ��޼����̴�.
		//����, this�� �����ص� �ǳ� Ȯ���ϰ� �ϱ����� this��.
		String pw = getInitParameter("pw");
		String path = getInitParameter("path");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println("���̵� : " + id + "<br/>");
		writer.println("��й�ȣ : " + pw + "<br/>");
		writer.println("path : " + path);
		writer.println("</body></html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
