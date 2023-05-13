package bookshop.controller.customer.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.dao.BookDAO;
import bookshop.dto.BookDTO;


@WebServlet("/searchWord")
public class SearchWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String sort = request.getParameter("sort");
		String searchWord = request.getParameter("searchWord");
		
		ArrayList<BookDTO> bookList = BookDAO.getInstance().getBookList(sort, searchWord);
		request.setAttribute("bookList", bookList);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("views/customer/bookList.jsp");
		dis.forward(request, response);
		
		
		
	}



}
