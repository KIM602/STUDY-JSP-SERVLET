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
	//DBCP���� Connection��ü�� ����µ� ����� ��ü�� ����
	
	public DbcpDAO() {
		try {
			Context context = new InitialContext();
			//Context�� �̸����� ��ü�� ã���ִ� �������̽�
			//InitialContext�� Context�������̽��� ������ Ŭ����
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			//lookup(String name)�� Object��ȯ�ϹǷ� ĳ����
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
			//DBCP���� Connection��ü�� ��� �͸� dataSource�� �̿��ϰ� ������ ������ �Ȱ���
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
