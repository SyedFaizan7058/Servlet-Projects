package com.servlet_files;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean_files.Doctor;
import com.dao_files.AddDoctorDAO;

@SuppressWarnings("serial")
@WebServlet("/addDr")
public class AddDoctorServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession hs = req.getSession();

		if (hs == null) {
			RequestDispatcher ds = req.getRequestDispatcher("message.jsp");
			ds.forward(req, resp);
		} else {

			Doctor dr = new Doctor();

			dr.setName(req.getParameter("name"));
			dr.setCity(req.getParameter("city"));
			dr.setMail(req.getParameter("mail"));
			dr.setPhno(Long.parseLong(req.getParameter("phno")));
			dr.setSpeciality(req.getParameter("spec"));

			int k = new AddDoctorDAO().addDoctor(dr);

			if (k > 0) {
				req.setAttribute("msg", "Record inserted successfully...");
				req.getRequestDispatcher("Home.jsp").forward(req, resp);
			}

		}

	}

}
