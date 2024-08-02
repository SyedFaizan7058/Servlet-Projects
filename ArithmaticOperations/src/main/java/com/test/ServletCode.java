package com.test;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/choice")
public class ServletCode extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String ope = req.getParameter("operation");
		RequestDispatcher rd;
		switch (ope) {

		case "Addition":
			rd = req.getRequestDispatcher("add");
			rd.forward(req, res);
			break;

		case "Substraction":
			rd = req.getRequestDispatcher("sub");
			rd.forward(req, res);
			break;
		case "Multiplication":
			rd = req.getRequestDispatcher("mul");
			rd.forward(req, res);
			break;
		case "Division":
			rd = req.getRequestDispatcher("div");
			rd.forward(req, res);
			break;
		case "Mod-Division":
			rd = req.getRequestDispatcher("modiv");
			rd.forward(req, res);
			break;
		case "Greater":
			rd = req.getRequestDispatcher("greater");
			rd.forward(req, res);
			break;
		default:
			rd = req.getRequestDispatcher("small");
			rd.forward(req, res);

		}

	}

}
