package com.test;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
@SuppressWarnings("serial")
public class ViewProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Cookie[] ck = req.getCookies();

		if (ck == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Fail.jsp");
			rd.forward(req, res);
		} else {
			String fName = ck[0].getValue();
			req.setAttribute("fName", fName);
			RequestDispatcher rd = req.getRequestDispatcher("ViewProfile.jsp");
			rd.forward(req, res);
		}
	}

}
