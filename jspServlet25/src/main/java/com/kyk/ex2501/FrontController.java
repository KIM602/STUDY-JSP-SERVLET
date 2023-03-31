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
//��û��ο� .do�� ������ �� �������� ������
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//�����������
	MyCommand comm; //MyCommand�� command ������ ���� �ʿ��� �������̽�
	//Command���� ���ô� command��Ű���� ����� commandó���� �ʿ��� �������̽��� ����� ������ ��û�� ���� commandŬ������ �׸� �����ϰ� �Ѵ�
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
			//Ȯ���� .do�� ��� ��û�� �̰����� ���Ƿ� ��û�̸�(��û��θ�)�� �ľ��Ͽ� ���� ó��
			String uri = request.getRequestURI(); //��û URI�� port��ȣ ������ ���ؽ�Ʈ�н������� ���(���ؽ�Ʈ[������Ʈ�̸�]�н�����)
			System.out.println("uri : " + uri);
			String conPath = request.getContextPath(); //context�н�(������Ʈ�̸�) ��ȯ
			System.out.println("conPath : " + conPath);
			String command = uri.substring(conPath.length()); //uri���� ���ؽ�Ʈ(������Ʈ��)�� ������ .do ��û���
			//subString(int beginIndex)�� beginIndex���� ������ ���ڿ��� ��ȯ
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
				System.out.println("�߸��� ��û�Դϴ�.");
			}
		}
	}

