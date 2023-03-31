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
    public LifeCycleEX() { //서블렛LifeCycleEx의 생성자
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
	//Servlet이 종료될시 한번 호출(생략하면 상위 HttpServlet의 메서드가 실행)
	public void destroy() {
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	//맨처음 요청시에 메서드로 여기서 doGet이나 doPost를 호출 전에 작업이 필요시(생략하면 상위 HttpServlet의 메서드가 실행)
	//보통 사용안함
	//protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//
	//}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter().append("GET방식 접속: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		response.getWriter().append("post방식 접속: ").append(request.getContextPath());
	}

	@PostConstruct
	//서블렛객체 생성 후 실행할 메서드를 지정(메서드는 임의로 만듬)
	private void initPostConstruct() {
		System.out.println("initPostConstruct");
	}
	
	@PreDestroy
	//서블렛을 종료하기 전에 실행되는 메서드 정의(destroy후에 완전 서블렛 제거전에 실행)
	private void destroyPreDestroy() {
		System.out.println("destroyPreDestroy");
	}
}
