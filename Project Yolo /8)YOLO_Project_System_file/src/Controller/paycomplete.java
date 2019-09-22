package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PayCompleteDAO;
import model.PayCompleteVO;

@WebServlet("/paycomplete")
public class paycomplete extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PayCompleteDAO dao = new PayCompleteDAO();
		HttpSession session = request.getSession();
		String hotelid = (String)session.getAttribute("payid");
		String id = (String)session.getAttribute("id");
		String checkin = (String)session.getAttribute("checkin");
		String checkout = (String)session.getAttribute("checkout");
		int price = (Integer)session.getAttribute("totalPrice");
		PayCompleteVO vo = new PayCompleteVO(id, hotelid, checkin, checkout, price);
		
		int cnt = dao.insertReservation(vo);
		if(cnt>0) {
			
			System.out.println("예약완료");
			response.sendRedirect("reservation_ok.jsp?success=yes");
			
		}else {
			
			System.out.println("예약실패");
			response.sendRedirect("reservation_ok.jsp?success=no");
			
		}
	}

}
