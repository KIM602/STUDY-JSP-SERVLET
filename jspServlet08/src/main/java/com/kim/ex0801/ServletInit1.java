package com.kim.ex0801;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInit1
 */
//web.xml이 아닌 @WebServlet어노테이션을 이용-이클립스의 servlet생성창을 이용
@WebServlet(
		urlPatterns = { "/ServletInit1" }, 
		initParams = { 
				@WebInitParam(name = "id", value = "kim"), 
				@WebInitParam(name = "pw", value = "12345"), 
				@WebInitParam(name = "path", value = "c:/kim/yk")
		})
public class ServletInit1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInit1() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		//web.xml에서 지정한 파라메터는 GET방식으로 전달됨
		String id = this.getInitParameter("id");
		//getInitParameter("name")은 HttpServlet의 메서드이므로 내가 만든 서블렛 클래스의 인스턴스메서드이다.
		//따라서, this를 생략해도 되나 확실하게 하기위해 this줌.
		String pw = getInitParameter("pw");
		String path = getInitParameter("path");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><head></head><body>");
		writer.println("아이디 : " + id + "<br/>");
		writer.println("비밀번호 : " + pw + "<br/>");
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
