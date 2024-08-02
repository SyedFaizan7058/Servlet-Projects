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
import com.dao_files.DeleteProductDAO;

@WebServlet("/delete")
@SuppressWarnings("serial")
public class DeleteProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession();

		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			String pcode = req.getParameter("pcode");
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> pb = (ArrayList<ProductBean>) hs.getAttribute("plist");

			List<ProductBean> list = pb.stream().filter(pp -> pp.getCode().equals(pcode)).collect(Collectors.toList());
			pb.remove(list.get(0));
			int k = new DeleteProductDAO().delete(pcode);

			if (k > 0) {
				req.setAttribute("msg", "Product Deleted Successfully...<br>");
				req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
			}
		}
	}

}
