package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CategoryDAO;
import model.HotelVO;

@WebServlet("/hotel_submit")
public class hotel_submit extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] categories = request.getParameterValues("category");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		

			CategoryDAO dao = new CategoryDAO();
			ArrayList<HotelVO> hotelvo = dao.CategoryCheck(checkin, checkout, categories);
			HttpSession session = request.getSession();
			session.setAttribute("checkin", checkin);
			session.setAttribute("checkout", checkout);
			session.setAttribute("hotelinfo", hotelvo);
			response.sendRedirect("hotel.jsp");

	
	}

}
