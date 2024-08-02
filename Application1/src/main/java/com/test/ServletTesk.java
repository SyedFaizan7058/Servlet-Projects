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
public class ServletTesk extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

		String name = req.getParameter("name");
		Integer age = Integer.parseInt(req.getParameter("age"));

		if (age > 18) {
			out.println(name + " is eliegible for vote..");
		} else {
			out.println(name + " is you are not eliegible for vote..");

		}

	}

}
