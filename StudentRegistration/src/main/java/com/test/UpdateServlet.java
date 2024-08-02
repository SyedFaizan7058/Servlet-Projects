package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Cookie[] ck = req.getCookies();
		
		if(ck==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}else {
			String name = ck[0].getValue();
			req.setAttribute("name", name);
			StudentBean sb=(StudentBean)req.getServletContext().getAttribute("sbean");
			int k = new UpdateDAO().update(sb);
			
			if(k>0) {
				req.setAttribute("msg", "Address Updated Successfully...<br>");
				req.getRequestDispatcher("Message.jsp").forward(req, res);
			}

		}
	}

}
