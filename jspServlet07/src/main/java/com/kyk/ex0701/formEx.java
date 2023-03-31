package com.kyk.ex0701;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formEx
 */
@WebServlet("/fex")
public class formEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public formEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		//get������� ���������� ���� �ѱ�ó���� ��Ĺ �ֽż��������� �ڵ� ����
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		//String javax.servlet.ServletRequest.getParameter(String arg0) : html�� form�� �Է� ��Ʈ���� name�Ӽ��� arg0�� ���� �Է°��� ��ȯ
		writer.println("<html><head></head><body>");
		writer.println("���̵� : " + id);
		writer.println("</body></html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		//post������� ���������� ���� �ѱ� ó��
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id��" + id);
		//checkbox�� �������� �����ϹǷ� request.getParameterValues("�Ӽ���")�� ����ϰ�
		//��ȯ�Ǵ� ���� ���ڿ� �迭�̴�
		String[] hobbys = request.getParameterValues("hobby");
		System.out.println("�迭" + Arrays.toString(hobbys));
		String major = request.getParameter("major");
		String Protocol = request.getParameter("protocol");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("���̵� : " + id + "<br/>");
		writer.println("��й�ȣ : " + pw + "<br/>");
		writer.println("��� : " + Arrays.toString(hobbys) + "<br/>");
		//Arrays.toString(hobbys)�� hobbys�迭�� ���ڿ��� ��ȯ
		writer.println("���� : " + major + "<br/>");
		writer.println("�������� : " + Protocol);
		writer.println("</body></html>");
	}

}