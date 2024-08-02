package com.test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forgot")
@SuppressWarnings("serial")
public class ForgotPasswordServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		UserBean ub = new CheckEmailDAO().checkMail(req.getParameter("mid"));

		if (ub == null) {
			req.setAttribute("msg", "Invalid EmailId...<br>");
			req.getRequestDispatcher("Fail.jsp").forward(req, res);
		} else {
			ServletContext sct = req.getServletContext();
			sct.setAttribute("userbean", ub);
			req.getRequestDispatcher("CheckEmail.jsp").forward(req, res);
		}

	}

}
