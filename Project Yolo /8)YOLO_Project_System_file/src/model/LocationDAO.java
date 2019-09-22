package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDAO {
	
	//호텔 좌표 가져오기
	
	public LocationVO hotelLocation(String hotelID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		LocationVO vo = null;
	    try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test1";
			String password = "1234";
			String sql = "SELECT * FROM PRODUCT WHERE HOTEL_ID=?";
			// 1. JDBC드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DBMS연결
			conn = DriverManager.getConnection(url, user, password);
			pst = conn.prepareStatement(sql);
			pst.setString(1, hotelID);
			
			// 3. SQL실행 후 처리
			rs = pst.executeQuery();
			
			if (rs.next()) {
				
				String hotel_name = rs.getString("HOTEL_NAME");
				Double locX = rs.getDouble("LOCATION_X");
				Double locY = rs.getDouble("LOCATION_Y");
				vo = new LocationVO(hotel_name,locX,locY);
			}
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
		return vo;
	}
	

}
