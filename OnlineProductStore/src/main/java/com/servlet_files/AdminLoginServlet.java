package com.servlet_files;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean_files.AdminBean;
import com.dao_files.AdminLoginDAO;

@WebServlet("/admin")
@SuppressWarnings("serial")
public class AdminLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		AdminBean ab = new AdminLoginDAO().login(name,pass);
		
		if(ab==null) {
			req.setAttribute("msg", "Invalid User Name or Password...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("abean", ab);
			req.getRequestDispatcher("Success.jsp").forward(req, res);
		}

	}

}
