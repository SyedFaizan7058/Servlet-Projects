package com.servlet_files;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean_files.UserBean;
import com.dao_files.CheckEmailDAO;

@WebServlet("/forgot")
@SuppressWarnings("serial")
public class ForgotPasswordServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		UserBean ub = new CheckEmailDAO().checkMail(req.getParameter("mid"));

		if (ub == null) {
			req.setAttribute("msg", "Invalid Emial-Id...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			ServletContext sct = req.getServletContext();
			sct.setAttribute("userbean", ub);
			req.getRequestDispatcher("CheckEmail.jsp").forward(req, res);
		}

	}

}
