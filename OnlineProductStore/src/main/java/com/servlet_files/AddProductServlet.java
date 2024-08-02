package com.servlet_files;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bean_files.AdminBean;
import com.bean_files.ProductBean;
import com.dao_files.AddProductADAO;

@WebServlet("/add")
@SuppressWarnings("serial")
public class AddProductServlet extends HttpServlet {

	ProductBean pb = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession(false);

		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {

			AdminBean ab = (AdminBean) hs.getAttribute("abean");
			if (ab != null) {
				pb = new ProductBean();

				pb.setCode(req.getParameter("code"));
				pb.setName(req.getParameter("name"));
				pb.setPrice(Double.parseDouble(req.getParameter("price")));
				pb.setQty(Integer.parseInt(req.getParameter("qty")));
				pb.setImageUrl(req.getParameter("url"));

				int k = new AddProductADAO().insert(pb);

				if (k > 0) {
					req.setAttribute("msg", "Product Added Successfully...<br><br>");
					req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
				}
			} else {
				req.setAttribute("msg", "First You Have to Login...<br>");
				req.getRequestDispatcher("Message.jsp").forward(req, res);
			}
		}
	}
}
