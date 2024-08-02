package com.test;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cal")
@SuppressWarnings("serial")
public class ServletProgram extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {

		String check = req.getParameter("check");

		if (check.equals("Prime")) {
			RequestDispatcher rd = req.getRequestDispatcher("/prime");
			rd.forward(req, res);
		} else if (check.equals("Factor")) {
			RequestDispatcher rd = req.getRequestDispatcher("/factor");
			rd.forward(req, res);
		} else if (check.equals("Factorial")) {
			RequestDispatcher rd = req.getRequestDispatcher("/factorial");
			rd.forward(req, res);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/square");
			rd.forward(req, res);
		}

	}

}
