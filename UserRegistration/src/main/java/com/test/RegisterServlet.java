package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		UserBean ub = new UserBean();

		ub.setuName(req.getParameter("name"));
		ub.setPass(req.getParameter("pass"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setMid(req.getParameter("mid"));
		ub.setPhno(Long.parseLong(req.getParameter("phno")));

		Integer k = new RegisterDAO().register(ub);

		if (k > 0) {

			EmailNotification.sendNotification(ub.getMid(), "User Registration!!!!", "Dear " + ub.getfName() + ",\r\n"
					+ "\r\n" + "Congratulations! Your registration is now completed...");

			req.setAttribute("msg", "User Registered Successfully...<br>");

			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, res);
		}
	}

}
