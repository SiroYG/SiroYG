package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

@WebServlet("/Join")
public class Join extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		
		
		Random ra = new Random();
		String pcode = String.valueOf(ra.nextInt(90000000)+10000000);
		MemberVO vo = new MemberVO(id,pw,name,tel,pcode);
		MemberDAO dao = new MemberDAO();
		boolean check = dao.pcodecheck(pcode);
		while(check) {
			System.out.println("이미있는 코드");
			pcode = String.valueOf(ra.nextInt(90000000)+10000000);
			check = dao.pcodecheck(pcode);
		}
		System.out.println(pcode);
		int cnt = dao.join(vo);
		System.out.println(cnt);
		if(cnt>0) {
			System.out.println("회원가입성공");
			response.sendRedirect("index.jsp");
			
		}else {
			System.out.println("회원가입실패");
		}
	}
}
