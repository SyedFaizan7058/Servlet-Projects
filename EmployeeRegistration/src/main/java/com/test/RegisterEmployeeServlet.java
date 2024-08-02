package com.test;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/reg")
@SuppressWarnings("serial")
public class RegisterEmployeeServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		EmployeeBean b = new EmployeeBean();

		b.setEmpId(Integer.parseInt(req.getParameter("eid")));
		b.setEmpName(req.getParameter("ename"));
		b.setEmpSalary(Float.parseFloat(req.getParameter("esalary")));
		b.setEmpAddr(req.getParameter("addr"));
		b.setEmpMailId(req.getParameter("mid"));
		b.setEmpPhno(Long.parseLong(req.getParameter("phno")));

		int k = new RegisterEmployeeDAO().registerEmployee(b);

		if (k > 0) {
			RequestDispatcher rd = req.getRequestDispatcher("RegisterEmployee.jsp");
			rd.forward(req, res);
		}
	}

}
