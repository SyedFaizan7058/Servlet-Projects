package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/f1")
@SuppressWarnings("serial")
public class FirstPageServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		StudentBean sb = new StudentBean();

		sb.setName(req.getParameter("name"));
		sb.setAge(Integer.parseInt(req.getParameter("age")));
		sb.setPhno(Long.parseLong(req.getParameter("number")));

		Cookie ck = new Cookie("name", sb.getName());
		res.addCookie(ck);

		req.getSession().setAttribute("sbean", sb);

		req.getRequestDispatcher("SecondPage.html").forward(req, res);
	}

}
