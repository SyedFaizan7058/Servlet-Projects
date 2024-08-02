package com.servlet_files;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao_files.AddProductADAO;

@WebServlet("/add")
@SuppressWarnings("serial")
public class AddProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ProductBean pb = new ProductBean();

		pb.setCode(req.getParameter("code"));
		pb.setName(req.getParameter("name"));
		pb.setPrice(Double.parseDouble(req.getParameter("price")));
		pb.setQty(Integer.parseInt(req.getParameter("qty")));

		int k = new AddProductADAO().insert(pb);

		if (k > 0) {
			req.setAttribute("msg", "Product Added Successfully...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}
	}

}
