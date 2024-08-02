package com.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/checkCode")
@SuppressWarnings("serial")
public class CheckBookByCodeServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		ArrayList<BookBean> list = new CheckBookByCodeDAO().checkCode(req.getParameter("code"));
		
		req.setAttribute("list", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("getBookByCode.jsp");
		
		rd.forward(req, res);

	}

}
