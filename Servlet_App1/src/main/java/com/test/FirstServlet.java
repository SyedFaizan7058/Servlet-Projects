package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/dis")
@SuppressWarnings("serial")
public class FirstServlet extends GenericServlet {

	public void init() {

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");

		pw.print("=====User Details=====");
		pw.print("<br>User Name :" + name);
		pw.print("<br>Password :" + pass);

	}

	public void destroy() {

	}

}
