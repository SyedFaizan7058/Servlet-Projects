package com.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/view")
@SuppressWarnings("serial")
public class ViewAllEmployeeByIdServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("eid"));
		ArrayList<EmployeeBean> list = new ViewAllEmployeeByIdDAO().getEmployeeByCode(id);

		req.setAttribute("list", list);

		RequestDispatcher rd = req.getRequestDispatcher("ViewAllEmployeeByCode.jsp");

		rd.forward(req, res);

	}

}
