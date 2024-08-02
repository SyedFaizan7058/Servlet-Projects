package com.test;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/display")
public class ServletCode extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("JSP_Demo.jsp");
		rd.forward(req, res);

	}

}
