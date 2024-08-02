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
import com.dao_files.UpdateProductDAO;

@WebServlet("/update")
@SuppressWarnings("serial")
public class UpdateProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession hs = req.getSession();

		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> pb = (ArrayList<ProductBean>) hs.getAttribute("plist");
			
			String code = req.getParameter("pcode");
			double price = Double.parseDouble(req.getParameter("price"));
			int qty = Integer.parseInt(req.getParameter("qty"));
			
			List<ProductBean> list = pb.stream().filter(pp ->pp.getCode().equals(code)).collect(Collectors.toList());
			list.get(0).setPrice(price);
			list.get(0).setQty(qty);
			
//			Second Way
//			ProductBean p = new ProductBean();
//			p.setPrice(Double.parseDouble(req.getParameter("price")));
//			p.setQty(Integer.parseInt(req.getParameter("qty")));
//			p.setCode(req.getParameter("pcode"));
			
			int k = new UpdateProductDAO().update(list.get(0));
			
			if(k>0) {
				req.setAttribute("msg", "Product Updated Successfully...<br>");
				req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
			}
		}
	}
}
