package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		StudentBean sb = new StudentBean();

		sb.setName(req.getParameter("name"));
		sb.setId(req.getParameter("id"));
		sb.setAddr(req.getParameter("addr"));
		sb.setPhno(req.getParameter("phno"));
		
		int k = new RegisterDAO().insert(sb);
		
		if(k>0) {
			req.setAttribute("msg", "Student registerd Successfully...<br>");
			req.getRequestDispatcher("Message.jsp").forward(req, res);
		}
	}

}
