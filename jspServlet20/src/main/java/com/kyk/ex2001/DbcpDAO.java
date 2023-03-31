package com.kyk.ex2001;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DbcpDAO {
	private DataSource dataSource;
	//DBCP에서 Connection객체를 만드는데 사용할 객체를 선언
	
	public DbcpDAO() {
		try {
			Context context = new InitialContext();
			//Context는 이름으로 객체를 찾아주는 인터페이스
			//InitialContext는 Context인터페이스를 구현한 클래스
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			//lookup(String name)은 Object반환하므로 캐스팅
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> memberSelect() {
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//DBCP에서 Connection객체를 얻는 것만 dataSource를 이용하고 나머지 절차는 똑같음
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM MEMBER");
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				MemberDTO dto = new MemberDTO(id, pw, name, phone);
				
				dtos.add(dto);
			}
		}
		catch(Exception e) {
			e.getMessage();
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
