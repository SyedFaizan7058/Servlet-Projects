package com.test;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/customer")
@SuppressWarnings("serial")
public class ServletTask extends GenericServlet {

	public void init() {

	}

	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {

		CustomerBean b = new CustomerBean();

		b.setId(req.getParameter("id"));
		b.setName(req.getParameter("name"));
		b.setCity(req.getParameter("city"));
		b.setMid(req.getParameter("mid"));
		b.setPhno(req.getParameter("phno"));
		
		AddCustomersDAO dao = new AddCustomersDAO();
		int k = dao.insert(b);
		
		if(k>0) {
			RequestDispatcher rd = req.getRequestDispatcher("AddCustomer.jsp");
			rd.forward(req, res);
		}

//		PrintWriter pw = res.getWriter();
//		res.setContentType("text/html");

//		String id = req.getParameter("id");
//		String name = req.getParameter("name");
//		String city = req.getParameter("city");
//		String mid = req.getParameter("mid");
//		String phno = req.getParameter("phno");
//
//		pw.println("=====Customer Details=====");
//		pw.println("<br><br>Customer Id :" + id);
//		pw.println("<br><br>Customer Name :" + name);
//		pw.println("<br><br>Customer City :" + city);
//		pw.println("<br><br>Customer Mail Id :" + mid);
//		pw.println("<br><br>Customer Phone Number :" + phno);
	}

}
