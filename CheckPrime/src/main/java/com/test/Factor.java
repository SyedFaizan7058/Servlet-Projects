package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/factor")
@SuppressWarnings("serial")
public class Factor extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		Integer number = Integer.parseInt(req.getParameter("number"));

		pw.println("Facrtors are :");
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				pw.println(i);
			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, res);

	}

}
