package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/welcome")
@SuppressWarnings("serial")
public class WecomeServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();

		res.setContentType("text/html");

		String name = req.getParameter("name");

		out.println("Welcome " + name);

	}

}
