package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ReservationDAO;

@WebServlet("/pay")
public class pay extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String hotelID = request.getParameter("hotelid");
		ReservationDAO dao = new ReservationDAO();
		int price = dao.getPay(hotelID);
		String checkIn = (String) session.getAttribute("checkin");
		String checkOut = (String) session.getAttribute("checkout");
		int dif = dao.getDateDifferecne(checkOut, checkIn);
		int total = price * dif;


		session.setAttribute("totalPrice", total);
		response.sendRedirect("pay.jsp?hotelid="+hotelID);



	}

}
