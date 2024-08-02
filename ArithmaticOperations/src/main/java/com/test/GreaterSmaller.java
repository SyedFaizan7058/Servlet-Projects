package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/greater")
@SuppressWarnings("serial")
public class GreaterSmaller extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		Integer v1 = Integer.parseInt(req.getParameter("value1"));
		Integer v2 = Integer.parseInt(req.getParameter("value2"));

		if (v1 > v2) {
			pw.println(v1 + " is Greater Number<br>");
		} else
			pw.println(v2 + " is Greater Number<br>");
		pw.println("===============================================");

		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, res);

	}

}