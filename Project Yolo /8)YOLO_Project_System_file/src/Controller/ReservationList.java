package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ReservationListDAO;
import model.ReservationListVO;

/**
 * Servlet implementation class ReservationList
 */
@WebServlet("/ReservationList")
public class ReservationList extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ReservationListVO> arr = new ArrayList<ReservationListVO>();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		ReservationListDAO dao = new ReservationListDAO();
		arr = dao.getreservationlist(id);
		session.setAttribute("reservationListArray", arr);
		response.sendRedirect("MyReservationList.jsp");
	
	}

}
