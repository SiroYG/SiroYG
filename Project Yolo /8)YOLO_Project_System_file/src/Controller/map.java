package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LocationDAO;
import model.LocationVO;

@WebServlet("/map")
public class map extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelID = request.getParameter("msg");
		
		LocationDAO dao = new LocationDAO();
		LocationVO vo = dao.hotelLocation(hotelID);
		
		String hotelName = vo.getHotelName();
		Double locX = vo.getLocationX();
		Double locY = vo.getLocationY(); 
		
		System.out.println("java map : "+hotelName+" " + locX + " " + locY);
		
		String jsonStr= "{\"name\" : \""+ hotelName +"\",\"locX\": \""+ locX+"\",\"locY\":\""+locY+"\"}";
		response.setContentType("application/json; charset=utf-8");
	    response.getWriter().print(jsonStr);
	}

}
