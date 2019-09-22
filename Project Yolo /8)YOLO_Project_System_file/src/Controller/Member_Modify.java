package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;

@WebServlet("/Member_Modify")
public class Member_Modify extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.member_modify(id,pw,name,tel);
		if(cnt>0) {
			System.out.println("회원정보 수정 성공");
			session.setAttribute("name",  name);
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("회원정보 수정 실패");
		}
		
		
	}

}
