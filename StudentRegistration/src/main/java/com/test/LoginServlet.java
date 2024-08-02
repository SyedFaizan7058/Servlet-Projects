package com.test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		StudentBean sb = new LoginDAO().login(req.getParameter("name"), req.getParameter("id"));

		if (sb == null) {
			req.setAttribute("msg", "Invalid User Name or Id!!!");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			ServletContext sct = req.getServletContext();
			sct.setAttribute("sbean", sb);
			Cookie ck = new Cookie("name", sb.getName());
			res.addCookie(ck);
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
	}

}
