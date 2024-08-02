package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/dis")
@SuppressWarnings("serial")
public class ServletCode extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();

		String name = req.getParameter("name");
		String pass = req.getParameter("pass");

		res.setContentType("text/html");

		if (name.equals("NareshIt") && pass.equals("nareshit@123")) {
			RequestDispatcher rd = req.getRequestDispatcher("welcome");
			rd.forward(req, res);

		} else {
			out.println("Sorry username or password error !!");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);

		}

	}

}
