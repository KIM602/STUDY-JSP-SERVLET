package com.kyk.ex2001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//DBó�� ���� Ŭ����
public class MemberDAO {
	//JDBD�� �ʿ��� ��ü ����
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	//con��ü ������ �ʿ��� �Ķ���Ϳ� ����
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	
	public MemberDAO() { //DAO��ü ������ ����̹� �ε�
		try { 
			Class.forName(driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> memberSelect() {
		//MemberDTO��ü�� ���ҷ� ���� ArrayList��ü dtos�� ����
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		//ArrayList�� �ݷ����� �ϵ����� List�迭�̸� ũ�Ⱑ �������� ó���ǰ� �پ��� �޼��� ����
		try {
			con = DriverManager.getConnection(url,uid,upw);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM MEMBER");
			while(rs.next()) {
				String id = rs.getString("id"); //�÷��̸����� �÷��� ���� ��ȯ
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				//MemberDTO��ü����(������ DB�� �÷����� �Ķ���ͷ� �ؼ� ����)
				MemberDTO dto = new MemberDTO(id,pw,name,phone);
				//add�޼��带 �̿��Ͽ� ArrayList�� ����
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
