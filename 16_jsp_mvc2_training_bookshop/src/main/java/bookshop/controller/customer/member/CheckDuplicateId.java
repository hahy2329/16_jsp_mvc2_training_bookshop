package bookshop.controller.customer.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.dao.MemberDAO;

@WebServlet("/checkDuplicatedId")
public class CheckDuplicateId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		if(MemberDAO.getInstance().checkDuplicateId(request.getParameter("memberId"))) {
			
			out.print("isDuple");
		}
		else {
			
			out.print("inNotDuple");
		}
		
		
		
	}

	


}
