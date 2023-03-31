package com.kyk.ex2001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//DB처리 전담 클래스
public class MemberDAO {
	//JDBD에 필요한 객체 선언
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	//con객체 생성에 필요한 파라메터용 변수
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public MemberDAO() { //DAO객체 생성시 드라이버 로드
		try { 
			Class.forName(driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> memberSelect() {
		//MemberDTO객체를 원소로 갖는 ArrayList객체 dtos를 만듬
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		//ArrayList는 콜렉션의 일동으로 List계열이며 크기가 가변으로 처리되고 다양한 메서드 제공
		try {
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM MEMBER");
			while(rs.next()) {
				String id = rs.getString("id"); //컬럼이름으로 컬럼의 값을 반환
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				//MemberDTO객체생성(생성시 DB의 컬럼값을 파라메터로 해서 만듬)
				MemberDTO dto = new MemberDTO(id,pw,name,phone);
				//add메서드를 이용하여 ArrayList에 저장
				dtos.add(dto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();
			}
			catch(Exception e1) {
				e1.getMessage();
			}
		}
		
		return dtos;
	}
}
