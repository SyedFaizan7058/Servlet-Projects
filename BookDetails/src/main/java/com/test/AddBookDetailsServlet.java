package com.test;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/add")
@SuppressWarnings("serial")
public class AddBookDetailsServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		BookBean b = new BookBean();

		b.setCode(req.getParameter("code"));
		b.setName(req.getParameter("name"));
		b.setAuthor(req.getParameter("author"));
		b.setPrice(Float.parseFloat(req.getParameter("price")));
		b.setQty(Integer.parseInt(req.getParameter("qty")));
		
		AddBookDetailsDAO a = new AddBookDetailsDAO();
		int k = a.insert(b);
		
		if(k>0) {
			RequestDispatcher rd = req.getRequestDispatcher("AddBookDetails.jsp");
			rd.forward(req, res);
		}
		

	}

}
