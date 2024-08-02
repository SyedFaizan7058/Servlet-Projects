package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/f2")
@SuppressWarnings("serial")
public class SecondPageServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Cookie[] ck = req.getCookies();

		if (ck == null) {
              
		} else {
			String name = ck[0].getValue();
			req.setAttribute("name", name);
			StudentBean ub = (StudentBean) req.getSession(false).getAttribute("sbean");
			ub.sethDegree(req.getParameter("deg"));
			ub.setYear(Integer.parseInt(req.getParameter("year")));
			ub.setUniversity(req.getParameter("uni"));

			req.getRequestDispatcher("StudentDetails.jsp").forward(req, res);
		}
	}

}