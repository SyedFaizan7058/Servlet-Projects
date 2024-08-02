package com.servlet_files;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao_files.ViewProductDAO;

@WebServlet("/view")
@SuppressWarnings("serial")
public class ViewProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ArrayList<ProductBean> list = new ViewProductDAO().retrieve();

		if (list.isEmpty()) {
			req.setAttribute("msg", "Table is Empty...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			req.getServletContext().setAttribute("list", list);
			req.getRequestDispatcher("ViewDetails.jsp").forward(req, res);
		}
	}

}
