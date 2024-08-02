package com.servlet_files;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean_files.ProductBean;
import com.bean_files.UserBean;
import com.dao_files.LoginDAO;
import com.dao_files.ViewAllProductDAO;

@WebServlet("/user")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String uName = req.getParameter("uName");
		String pass = req.getParameter("pWord");

		UserBean ub = new LoginDAO().login(uName, pass);
		
		if(ub==null) {
			req.setAttribute("msg", "Invalid User Name or Password...");
			RequestDispatcher rd = req.getRequestDispatcher("Message.jsp");
			rd.forward(req, res);
		}else {
			ArrayList<ProductBean> list = new ViewAllProductDAO().fetch();
			req.getSession().setAttribute("plist", list);
			req.getSession().setAttribute("ubean", ub);
			RequestDispatcher rd = req.getRequestDispatcher("ViewAllProduct2.jsp");
			rd.forward(req, res);
		}

	}

}
