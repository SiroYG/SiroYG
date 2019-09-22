package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	//회원가입
	public int join(MemberVO vo) {
	
		String id = vo.getId();
		String pw = vo.getPw();
		String name = vo.getName();
		String tel = vo.getTel();
		String pcode = vo.getPcode();
		int cnt = 0;
		System.out.println(id + " " + pw + " " + name + " " + tel + " " + pcode);
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test1";
			String password = "1234";
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,1)";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			pst.setString(3, name);
			pst.setString(4, tel);
			pst.setString(5, pcode);
			
			cnt = pst.executeUpdate();
			return cnt;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	//로그인
	public String loginCheck(String id, String pw) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String name = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test1";
			String password = "1234";
			String sql = "SELECT * FROM MEMBER WHERE id=?";
			// 1. JDBC드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DBMS연결
			conn = DriverManager.getConnection(url, user, password);
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			// 3. SQL실행 후 처리
			rs = pst.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(2).equals(pw)) {
					name=rs.getString(3);
				}
			}
			return name;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return name;
	}
	
	
	
	public boolean pcodecheck(String pcode) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean isCheck = false;

		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test1";
			String password = "1234";
			String sql = "SELECT * FROM MEMBER WHERE USER_CODE=?";
			// 1. JDBC드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DBMS연결
			conn = DriverManager.getConnection(url, user, password);
			pst = conn.prepareStatement(sql);
			pst.setString(1, pcode);

			// 3. SQL실행 후 처리
			rs = pst.executeQuery();

			if (rs.next()) {
				isCheck = true;
			}
			return isCheck;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isCheck;
	}
	
	//회원정보 수정
	public int member_modify(String id, String pw, String name, String tel) {
		
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test1";
			String password = "1234";
			String sql = "update member set pw=?,name=?,tel=? where id=?";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, pw);
			pst.setString(2, name);
			pst.setString(3, tel);
			pst.setString(4, id);
			
			cnt = pst.executeUpdate();
			
			conn.prepareStatement("commit");
			return cnt;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	

}

