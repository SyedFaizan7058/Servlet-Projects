package com.servlet_files;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit")
@SuppressWarnings("serial")
public class EditProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);

		if (hs == null) {
			req.setAttribute("Session Expired...<br>", hs);
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
		}
	}

}
