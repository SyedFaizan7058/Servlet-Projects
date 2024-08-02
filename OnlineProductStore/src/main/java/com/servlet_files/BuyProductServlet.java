package com.servlet_files;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean_files.ProductBean;

@WebServlet("/buy")
@SuppressWarnings("serial")
public class BuyProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);

		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			try {
				@SuppressWarnings("unchecked")
				ArrayList<ProductBean> plist = (ArrayList<ProductBean>) hs.getAttribute("plist");

				List<ProductBean> pl = plist.stream().filter(l -> l.getCode().equals(req.getParameter("pcode")))
						.collect(Collectors.toList());
				hs.setAttribute("pl", pl.get(0));
				req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
			} catch (NullPointerException e) {
				req.setAttribute("msg", "You Are LoggedOut Please Login First...<br>");
				req.getRequestDispatcher("Message.jsp").forward(req, res);
			}
		}
	}

}
