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

@WebServlet("/viewCart")
@SuppressWarnings("serial")
public class ViewCartServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ArrayList<ProductBean> cart = (ArrayList<ProductBean>) session.getAttribute("cart");

		if (cart == null) {
			cart = new ArrayList<ProductBean>();
			session.setAttribute("cart", cart);
		}

		request.setAttribute("cart", cart);
		request.getRequestDispatcher("AddToCart.jsp").forward(request, response);
	}
}
