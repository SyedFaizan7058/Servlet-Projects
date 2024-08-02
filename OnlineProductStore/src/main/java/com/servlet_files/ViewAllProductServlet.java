package com.servlet_files;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean_files.ProductBean;
import com.dao_files.ViewAllProductDAO;

@WebServlet("/view1")
@SuppressWarnings("serial")
public class ViewAllProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession();

		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			ArrayList<ProductBean> list = new ViewAllProductDAO().fetch();
			hs.setAttribute("plist", list);
			req.getRequestDispatcher("ViewAllProducts.jsp").forward(req, res);
		}
	}

}
