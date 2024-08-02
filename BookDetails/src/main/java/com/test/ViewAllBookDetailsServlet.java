package com.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/view")
@SuppressWarnings("serial")
public class ViewAllBookDetailsServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		ViewAllBookDetails vb = new ViewAllBookDetails();
		ArrayList<BookBean> list = vb.retreive();

		req.setAttribute("list", list);

		RequestDispatcher rd = req.getRequestDispatcher("ViewBooks.jsp");
		rd.forward(req, res);
	}

}
