package com.faizan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/submit form")
@SuppressWarnings("serial")
public class FirstServlet extends GenericServlet {

	// This is life cycle of a servlet_ program

	@Override
	public void init() {

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String name = req.getParameter("name");
		String phno = req.getParameter("phone");
		String email = req.getParameter("email");
		String addr = req.getParameter("address");
		String msg = req.getParameter("message");
		pw.println("======User Details======");
		pw.println("<br><br>User Name :" + name);
		pw.println("<br><br>Phone Number :" + phno);
		pw.println("<br><br>Emial Id :" + email);
		pw.println("<br><br>User Address :" + addr);
		pw.println("<br><br>Message :" + msg);

	}

	@Override
	public void destroy() {

	}

}
