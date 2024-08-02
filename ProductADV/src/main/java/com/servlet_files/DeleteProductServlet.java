package com.servlet_files;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao_files.DeleteProductDAO;

@WebServlet("/delete")
@SuppressWarnings("serial")
public class DeleteProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int k = new DeleteProductDAO().delete(req.getParameter("code"));

		if (k > 0) {
			req.setAttribute("msg", "Product Deleted Successfully...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			req.setAttribute("msg", "Invalid Product Id...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}
	}

}
