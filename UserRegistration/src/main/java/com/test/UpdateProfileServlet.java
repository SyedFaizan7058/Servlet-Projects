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
public class UpdateProfileServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Cookie[] ck = req.getCookies();

		if (ck == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Fail.jsp").forward(req, res);
		} else {
			String fName = ck[0].getValue();
			req.setAttribute("fName", fName);
			UserBean ub = (UserBean) req.getServletContext().getAttribute("ubean");
			try {

				req.setAttribute("msg", "First You Have to Login...<br>");
				req.getRequestDispatcher("Fail.jsp").forward(req, res);

			} catch (Exception e) {
				ub.setAddr(req.getParameter("addr"));
				ub.setMid(req.getParameter("mid"));
				ub.setPhno(Long.parseLong(req.getParameter("phno")));
				int k = new UpdateProfileDAO().update(ub);

				if (k > 0) {
					req.setAttribute("msg", "Profile Updated Successfully...<br>");
					req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
				}
			}
		}

	}
}
