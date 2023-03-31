package com.kyk.ex0601;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleEX
 */
@WebServlet("/LCE")
public class LifeCycleEX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleEX() { //����LifeCycleEx�� ������
        super();
        System.out.println("construct");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	//Servlet�� ����ɽ� �ѹ� ȣ��(�����ϸ� ���� HttpServlet�� �޼��尡 ����)
	public void destroy() {
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	//��ó�� ��û�ÿ� �޼���� ���⼭ doGet�̳� doPost�� ȣ�� ���� �۾��� �ʿ��(�����ϸ� ���� HttpServlet�� �޼��尡 ����)
	//���� ������
	//protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//
	//}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter().append("GET��� ����: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		response.getWriter().append("post��� ����: ").append(request.getContextPath());
	}

	@PostConstruct
	//������ü ���� �� ������ �޼��带 ����(�޼���� ���Ƿ� ����)
	private void initPostConstruct() {
		System.out.println("initPostConstruct");
	}
	
	@PreDestroy
	//������ �����ϱ� ���� ����Ǵ� �޼��� ����(destroy�Ŀ� ���� ���� �������� ����)
	private void destroyPreDestroy() {
		System.out.println("destroyPreDestroy");
	}
}
