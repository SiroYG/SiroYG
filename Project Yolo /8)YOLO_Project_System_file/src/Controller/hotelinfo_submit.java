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

@WebServlet("/hotelinfo_submit")
public class hotelinfo_submit extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		
			CategoryDAO dao = new CategoryDAO();
			HttpSession session = request.getSession();
			String hotelID = (String)session.getAttribute("HotelID");
			String hotelName = dao.getHotelName(hotelID);
			ArrayList<HotelVO> hotelvo = dao.CategoryCheck(checkin, checkout, hotelName);
			session.setAttribute("checkin", checkin);
			session.setAttribute("checkout", checkout);
			session.setAttribute("hotelinfo", hotelvo);
			response.sendRedirect("hotelinfo2.jsp?hotelid="+hotelID);

	
	}

}
