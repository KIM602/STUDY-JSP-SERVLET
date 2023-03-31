package com.kyk.ex2601;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherEx
 */
@WebServlet("/DEX")
public class DispatcherEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherEx() {
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
		System.out.println("actionDo");
		//Ŭ���̾�Ʈ�κ��� ���� request��ü�� �Ӽ��� �߰�
		//request��ü�� �Ӽ��� �߰��� setAttribute("�Ӽ���", ��);
		request.setAttribute("id", "abcde"); //request��ü�� id�Ӽ��� ����� ���� abcde�� �Ѵ�.
		request.setAttribute("pw", "12345");
		
		//!!!!�߿�!!!!
		RequestDispatcher dispatcher = request.getRequestDispatcher("/dispatcherJsp.jsp");
		//dispatcherJsp.jsp�� ������ �̵�
		dispatcher.forward(request, response);
	}

}
