package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String uName = req.getParameter("uName");
		String pass = req.getParameter("pWord");

		UserBean ub = new LoginDAO().login(uName, pass);
		
		if(ub==null) {
			req.setAttribute("msg", "Invalid Login Process...");
			RequestDispatcher rd = req.getRequestDispatcher("Fail.jsp");
			rd.forward(req, res);
		}else {
			ServletContext context = req.getServletContext();
			
			context.setAttribute("ubean", ub);
			Cookie ck = new Cookie("fname", ub.getfName());
			res.addCookie(ck);
			
			RequestDispatcher rd = req.getRequestDispatcher("LogSuccess.jsp");
			rd.forward(req, res);
		}

	}

}
