package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/change")
@SuppressWarnings("serial")
public class ChangePasswordServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String pass1 = req.getParameter("pass1");
		String pass2 = req.getParameter("pass2");
		
		if(pass1.equals(pass2)) {
			UserBean ub = (UserBean)req.getServletContext().getAttribute("userbean");
			ub.setPass(pass2);
			int k = new ChangePasswordDAO().updatePassword(ub);
			
			if(k>0) {
				req.setAttribute("msg", "Password Changed Successfully...<br>");
				req.getRequestDispatcher("Fail.jsp").forward(req, res);
			}
		}else {
			req.setAttribute("msg", "Confirmation Password is Wrong...<br>");
			req.getRequestDispatcher("Forgot.jsp").forward(req, res);
		}
	}

}
