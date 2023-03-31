package com.kyk.ex2501;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kyk.ex2501.command.MyCommand;

/**
 * Servlet implementation class FrontController
 */
//요청경로에 .do가 있으면 이 서블렛으로 접속함
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//멤버변수선언
	MyCommand comm; //MyCommand는 command 패턴을 사용시 필요한 인터페이스
	//Command패턴 사용시는 command패키지를 만들고 command처리에 필요한 인터페이스를 만들어 각각의 요청에 사용될 command클래스가 그를 구현하게 한다
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
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
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			System.out.println("actionDo");
			//확장자 .do의 모든 요청이 이곳으로 오므로 요청이름(요청경로명)을 파악하여 각각 처리
			String uri = request.getRequestURI(); //요청 URI는 port번호 이후의 컨텍스트패스부터의 경로(컨텍스트[프로젝트이름]패스부터)
			System.out.println("uri : " + uri);
			String conPath = request.getContextPath(); //context패스(프로젝트이름) 반환
			System.out.println("conPath : " + conPath);
			String command = uri.substring(conPath.length()); //uri에서 컨텍스트(프로젝트명)을 제거한 .do 요청경로
			//subString(int beginIndex)는 beginIndex부터 나머지 문자열을 반환
			System.out.println("command : " + command);
			if(command.equals("/insert.do")) {
				System.out.println("insert");
				System.out.println("---------------------");
				comm = new InsertCommand();
				comm.execute();
			}
			else if(command.equals("/update.do")) {
				System.out.println("update");
				System.out.println("---------------------");
				comm = new UpdateCommand();
				comm.execute();
				
			}
			else if(command.equals("/select.do")) {
				System.out.println("select");
				System.out.println("---------------------");
			}
			else if(command.equals("/delete.do")) {
				System.out.println("delete");
				System.out.println("---------------------");
			}
			else if(command.equals("/")) {
				System.out.println("default");
			}
			else {
				System.out.println("잘못된 요청입니다.");
			}
		}
	}

