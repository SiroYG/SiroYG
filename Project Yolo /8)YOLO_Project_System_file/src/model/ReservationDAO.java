package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAO {

	//예약가능 날짜 검색
	public ArrayList<HotelVO> availableReservation(String checkin, String checkout) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<HotelVO> ar = new ArrayList<>();
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test1";
			String password = "1234";
			String sql = "select * from product p where not exists(select * from reservation where hotel_id=p.hotel_id and ((date_in <= to_date(?,'MM/DD/YYYY') and date_out > to_date(?,'MM/DD/YYYY'))or (date_in < to_date(?,'MM/DD/YYYY') and date_out >= to_date(?,'MM/DD/YYYY'))))";
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
			
			while(rs.next()) {
				if(rs.getInt(6)!=0) {
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
					HotelVO vo = new HotelVO(hotel_id, hotel_name, room_name, price, info, c_person, category, location, location_x, location_y, cal, addr, score, img1, img2, hotel_title, img3, img4);
					ar.add(vo);
				}
				
			}
			return ar;

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
		return ar;
	}
	
	//호텔 가격 불러오기 - 결제
		public int getPay(String hotelID) {
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			ArrayList<HotelVO> ar = new ArrayList<>();
			int price = 0;
			try {
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "test1";
				String password = "1234";
				String sql = "select price from product where hotel_id=?";
				// 1. JDBC드라이버 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2. DBMS연결
				conn = DriverManager.getConnection(url, user, password);
				pst = conn.prepareStatement(sql);
				pst.setString(1, hotelID);

				// 3. SQL실행 후 처리
				rs = pst.executeQuery();
				
				if(rs.next()) {
					
					price = rs.getInt(1);
					
				}
				return price;

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
			return price;
		}
		
		
	//날짜 차이 계산하기

		public int getDateDifferecne(String checkout, String checkin) {
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			ArrayList<HotelVO> ar = new ArrayList<>();
			int dif = 0;
			try {
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "test1";
				String password = "1234";
				String sql = "select to_date(?,'MM/DD/YYYY')- to_date(?, 'MM/DD/YYYY') datediff from dual";
				// 1. JDBC드라이버 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2. DBMS연결
				conn = DriverManager.getConnection(url, user, password);
				pst = conn.prepareStatement(sql);
				pst.setString(1, checkout);
				pst.setString(2, checkin);

				// 3. SQL실행 후 처리
				rs = pst.executeQuery();
				
				if(rs.next()) {
					
					dif = rs.getInt(1);
					
				}
				return dif;

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
			return dif;
		}
	
}
