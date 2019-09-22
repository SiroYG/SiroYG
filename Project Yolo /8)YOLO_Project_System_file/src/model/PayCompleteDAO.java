package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PayCompleteDAO {

	
	public int insertReservation(PayCompleteVO vo) {
		
		String id = vo.getId();
		String hotelid = vo.getHotelid();
		String checkin = vo.getCheckin();
		String checkout = vo.getCheckout();
		int price = vo.getPrice();
		int cnt = 0;
		
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test1";
			String password = "1234";
			String sql = "INSERT INTO RESERVATION VALUES(reservationnum.nextval,?,?,?,to_date(?,'MM/DD/YYYY'),to_date(?,'MM/DD/YYYY'))";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, hotelid);
			pst.setString(2, id);
			pst.setInt(3, price);
			pst.setString(4, checkin);
			pst.setString(5, checkout);
			
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
}
