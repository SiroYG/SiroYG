package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ReservationListDAO {
	
	public ArrayList<ReservationListVO> getreservationlist(String id) {
		ArrayList<ReservationListVO> arr = new ArrayList<ReservationListVO>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String name = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test1";
			String password = "1234";
			String sql = "select reservation.reservation_num,product.hotel_name,product.hotel_room_name,product.cal,product.address,reservation.date_in,reservation.date_out,reservation.price,product.location_x,product.location_y from reservation, product where (id=? and reservation.hotel_id=product.hotel_id) order by reservation.reservation_num asc";
			// 1. JDBC드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. DBMS연결
			conn = DriverManager.getConnection(url, user, password);
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			// 3. SQL실행 후 처리
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				String hotelName = rs.getString(2);
				String roomname = rs.getString(3);
				int price = rs.getInt(8);
				String cal = rs.getString(4);
				String addr = rs.getString(5);
				Date datein = rs.getDate(6);
				Date dateout = rs.getDate(7);
				Double locX = rs.getDouble(9);
				Double locY = rs.getDouble(10);
				ReservationListVO vo = new ReservationListVO(hotelName, roomname, addr, cal, datein, dateout, price, locX, locY);
				arr.add(vo);
				
			}
			return arr;

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
		return arr;
	}

}
