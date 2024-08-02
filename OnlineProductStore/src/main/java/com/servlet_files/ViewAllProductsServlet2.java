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

@SuppressWarnings("serial")
@WebServlet("/view2")
public class ViewAllProductsServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);

		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			ArrayList<ProductBean> list = new ViewAllProductDAO().fetch();
			hs.setAttribute("plist", list);
			req.getRequestDispatcher("ViewAllProduct2.jsp").forward(req, res);
		}
	}

}
