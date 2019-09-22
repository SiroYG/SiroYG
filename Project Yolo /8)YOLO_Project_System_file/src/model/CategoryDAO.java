package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO {

	public ArrayList<HotelVO> CategoryCheck(String checkin, String checkout, String[] cg) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<HotelVO> hotelvo = new ArrayList<HotelVO>();

	
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test1";
			String password = "1234";
			String sql = "select * from product p where not exists(select * from reservation where hotel_id=p.hotel_id and ((date_in <= to_date(?,'MM/DD/YYYY') and date_out > to_date(?,'MM/DD/YYYY'))or (date_in < to_date(?,'MM/DD/YYYY') and date_out >= to_date(?,'MM/DD/YYYY'))))";
			String sqlplus = "";
			if(cg!=null) {
			for (String category : cg) {

				String sql2 = " and p.category like '%"+ category +"%'";
				sqlplus += sql2;

			}
			
			
			sql = sql + sqlplus ;
			}
			
			System.out.println(sql);

			// 1. JDBC드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DBMS연결
			conn = DriverManager.getConnection(url, user, password);
			pst = conn.prepareStatement(sql);
			pst.setString(1, checkin);
			pst.setString(2, checkin);
			pst.setString(3, checkout);
			pst.setString(4, checkout);
		

			// 3. SQL실행 후 처리
			rs = pst.executeQuery();

			while (rs.next()) {
				if (rs.getInt(6) != 0) {
					String hotel_id = rs.getString(1);
					String hotel_name = rs.getString(2);
					String room_name = rs.getString(3);
					int price = rs.getInt(4);
					String info = rs.getString(5);
					int c_person = rs.getInt(6);
					String category = rs.getString(7);
					String location = rs.getString(8);
					double location_x = rs.getDouble(9);
					double location_y = rs.getDouble(10);
					String cal = rs.getString(11);
					String addr = rs.getString(12);
					int score = rs.getInt(13);
					String img1 = rs.getString(14);
					String img2 = rs.getString(15);
					String hotel_title = rs.getString(16);
					String img3 = rs.getString(17);
					String img4 = rs.getString(18);
					HotelVO vo = new HotelVO(hotel_id, hotel_name, room_name, price, info, c_person, category, location,
							location_x, location_y, cal, addr, score, img1, img2, hotel_title, img3, img4);
					hotelvo.add(vo);
				}

			}
			return hotelvo;

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
		return hotelvo;
	}
	
	//호텔 이름 가져오기
	public String getHotelName(String hotelid) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String hotelName = null;
		ArrayList<HotelVO> hotelvo = new ArrayList<HotelVO>();

	
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test1";
			String password = "1234";
			String sql = "select hotel_name from product where hotel_id=?";
			

			// 1. JDBC드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DBMS연결
			conn = DriverManager.getConnection(url, user, password);
			pst = conn.prepareStatement(sql);
			pst.setString(1, hotelid);

		

			// 3. SQL실행 후 처리
			rs = pst.executeQuery();

			if (rs.next()) {
				hotelName = rs.getString(1);

			}
			return hotelName;

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
		return hotelName;
	}
	
	
	public ArrayList<HotelVO> CategoryCheck(String checkin, String checkout, String hotelname) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<HotelVO> hotelvo = new ArrayList<HotelVO>();

	
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test1";
			String password = "1234";
			String sql = "select * from product p where (hotel_name=? and not exists(select * from reservation where hotel_id=p.hotel_id and ((date_in <= to_date(?,'MM/DD/YYYY') and date_out > to_date(?,'MM/DD/YYYY'))or (date_in < to_date(?,'MM/DD/YYYY') and date_out >= to_date(?,'MM/DD/YYYY')))))";
			
			System.out.println(sql);

			// 1. JDBC드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DBMS연결
			conn = DriverManager.getConnection(url, user, password);
			pst = conn.prepareStatement(sql);
			pst.setString(1, hotelname);
			pst.setString(2, checkin);
			pst.setString(3, checkin);
			pst.setString(4, checkout);
			pst.setString(5, checkout);
		

			// 3. SQL실행 후 처리
			rs = pst.executeQuery();

			while (rs.next()) {
				if (rs.getInt(6) != 0) {
					String hotel_id = rs.getString(1);
					String hotel_name = rs.getString(2);
					String room_name = rs.getString(3);
					int price = rs.getInt(4);
					String info = rs.getString(5);
					int c_person = rs.getInt(6);
					String category = rs.getString(7);
					String location = rs.getString(8);
					double location_x = rs.getDouble(9);
					double location_y = rs.getDouble(10);
					String cal = rs.getString(11);
					String addr = rs.getString(12);
					int score = rs.getInt(13);
					String img1 = rs.getString(14);
					String img2 = rs.getString(15);
					String hotel_title = rs.getString(16);
					String img3 = rs.getString(17);
					String img4 = rs.getString(18);
					HotelVO vo = new HotelVO(hotel_id, hotel_name, room_name, price, info, c_person, category, location,
							location_x, location_y, cal, addr, score, img1, img2, hotel_title, img3, img4);
					hotelvo.add(vo);
				}

			}
			return hotelvo;

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
		return hotelvo;
	}

}
