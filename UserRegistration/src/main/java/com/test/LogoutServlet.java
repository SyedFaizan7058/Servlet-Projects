package com.test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Cookie[] ck = req.getCookies();

		if (ck == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Fail.jsp").forward(req, res);
		} else {
			ck[0].setMaxAge(-2);
			res.addCookie(ck[0]);
			ServletContext sct = this.getServletContext();
			sct.removeAttribute("ubean");
			req.setAttribute("msg", "User Logged Out Successfully and Session Epired...<br>");
			req.getRequestDispatcher("Fail.jsp").forward(req, res);
		}

	}

}
