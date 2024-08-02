package com.servlet_files;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/conform")
@SuppressWarnings("serial")
public class ConfirmBuyProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);

		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			/* We can also do this process using url_re-write */
//			@SuppressWarnings("unchecked")
//			ArrayList<ProductBean> plist = (ArrayList<ProductBean>)hs.getAttribute("plist");
			String qty = req.getParameter("qty");
			req.getServletContext().setAttribute("qty", qty);
			req.getServletContext().setAttribute("req", req);
			req.getServletContext().setAttribute("res", res);
			req.getRequestDispatcher("Payment.jsp").forward(req, res);
		}

	}

}
