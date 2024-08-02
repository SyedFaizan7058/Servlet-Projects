package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/div")
public class Division extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		Integer v1 = Integer.parseInt(req.getParameter("value1"));
		Integer v2 = Integer.parseInt(req.getParameter("value2"));

		Integer div = 0;
		if (v2 != 0) {
			div = v1 / v2;
		}
		pw.println("Division :" + div + "<br>");
		pw.println("===============================================");

		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, res);

	}

}
