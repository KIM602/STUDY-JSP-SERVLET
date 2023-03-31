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
		//get방식으로 브라우저에서 오는 한글처리는 톰캣 최신서버에서는 자동 지원
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		//String javax.servlet.ServletRequest.getParameter(String arg0) : html의 form의 입력 컨트롤의 name속성이 arg0인 것의 입력값을 반환
		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id);
		writer.println("</body></html>");
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		//post방식으로 브라우저에서 오는 한글 처리
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id는" + id);
		//checkbox는 복수개를 선택하므로 request.getParameterValues("속성명")을 사용하고
		//반환되는 값은 문자열 배열이다
		String[] hobbys = request.getParameterValues("hobby");
		System.out.println("배열" + Arrays.toString(hobbys));
		String major = request.getParameter("major");
		String Protocol = request.getParameter("protocol");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id + "<br/>");
		writer.println("비밀번호 : " + pw + "<br/>");
		writer.println("취미 : " + Arrays.toString(hobbys) + "<br/>");
		//Arrays.toString(hobbys)은 hobbys배열을 문자열로 반환
		writer.println("전공 : " + major + "<br/>");
		writer.println("프로토콜 : " + Protocol);
		writer.println("</body></html>");
	}

}