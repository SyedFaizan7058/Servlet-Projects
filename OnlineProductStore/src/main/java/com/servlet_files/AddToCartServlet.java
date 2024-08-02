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

@WebServlet("/addToCart")
@SuppressWarnings("serial")
public class AddToCartServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		ArrayList<ProductBean> cart;

		if (session.getAttribute("cart") == null) {
			cart = new ArrayList<ProductBean>();
			session.setAttribute("cart", cart);
		} else {
			cart = (ArrayList<ProductBean>) session.getAttribute("cart");
		}

		String code = req.getParameter("pCode");
		String name = req.getParameter("pName");
		double price = Double.parseDouble(req.getParameter("price"));
		int qty = Integer.parseInt(req.getParameter("qty"));

		ProductBean product = new ProductBean(code, name, price, qty);

		cart.add(product);

		req.getRequestDispatcher("viewCart").forward(req, res);
	}
}
