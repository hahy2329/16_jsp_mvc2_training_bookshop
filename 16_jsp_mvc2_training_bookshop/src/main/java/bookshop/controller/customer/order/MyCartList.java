package bookshop.controller.customer.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.dao.BookDAO;
import bookshop.dao.MemberDAO;
import bookshop.dto.BookDTO;


@WebServlet("/myCartList")
public class MyCartList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setAttribute("memberDTO", MemberDAO.getInstance().getMemberDetail((String)session.getAttribute("memberId")));
		int bookCd = Integer.parseInt(request.getParameter("bookCd"));
		ArrayList<BookDTO> bookDTO = (ArrayList)session.getAttribute("bookDTO");
		if(bookDTO == null) {
			bookDTO = new ArrayList<BookDTO>();
		}
		
		bookDTO.add(BookDAO.getInstance().getBookDetail(bookCd));
		session.setAttribute("bookDTO", bookDTO);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
