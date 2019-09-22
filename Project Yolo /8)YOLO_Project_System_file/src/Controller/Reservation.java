package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HotelVO;
import model.MemberDAO;
import model.ReservationDAO;

@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<HotelVO> ar = new ArrayList<>();
		String checkIn = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");

		ReservationDAO dao = new ReservationDAO();
		ar = dao.availableReservation(checkIn, checkout);

		// System.out.println(ar.toString());

		HttpSession session = request.getSession();

		session.setAttribute("hotelinfo", ar);
		session.setAttribute("checkin", checkIn);
		session.setAttribute("checkout", checkout);

		response.sendRedirect("hotel.jsp");

	}

}
