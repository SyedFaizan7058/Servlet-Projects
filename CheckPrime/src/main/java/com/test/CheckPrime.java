package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/prime")
public class CheckPrime extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		Integer number = Integer.parseInt(req.getParameter("number"));

		boolean flag = true;
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				flag = false;
				break;
			}
		}

		if (flag && number > 1) {
			pw.println("<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Check Prime</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
					+ "<script type=\"text/javascript\" src=\"script.js\"></script>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<div class=\"main\"style='height:250px;'>"
					+"<p style='color:white;'>"+ number +" is Prime Number"+"</p>"
					+ "		<form action=\"cal\" method=\"post\" onsubmit=\"return checkNumber()\">\r\n"
					+ "		<label for=\"number\">Value :</label>\r\n"
					+ "			<input type=\"number\" id=\"number\" name=\"number\" placeholder=\"Enter the number\"><br><br>\r\n"
					+ "			<input type=\"submit\" value=\"Prime\" name=\"check\">\r\n"
					+ "			<input type=\"submit\" value=\"Factor\" name=\"check\"><br><br>\r\n"
					+ "			<input type=\"submit\" value=\"Factorial\" name=\"check\">\r\n"
					+ "			<input type=\"submit\" value=\"Square\" name=\"check\">\r\n"
					+ "		</form>\r\n"
					+ "	</div>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			
		} else {
			//pw.println(number + " is not Prime Number");
			pw.println("<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Check Prime</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"style.css\">\r\n"
					+ "<script type=\"text/javascript\" src=\"script.js\"></script>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<div class=\"main\"style='height:250px;'>"
					+"<p style='color:white;'>"+ number +" is Not Prime Number"+"</p>"
					+ "		<form action=\"cal\" method=\"post\" onsubmit=\"return checkNumber()\">\r\n"
					+ "		<label for=\"number\">Value :</label>\r\n"
					+ "			<input type=\"number\" id=\"number\" name=\"number\" placeholder=\"Enter the number\"><br><br>\r\n"
					+ "			<input type=\"submit\" value=\"Prime\" name=\"check\">\r\n"
					+ "			<input type=\"submit\" value=\"Factor\" name=\"check\"><br><br>\r\n"
					+ "			<input type=\"submit\" value=\"Factorial\" name=\"check\">\r\n"
					+ "			<input type=\"submit\" value=\"Square\" name=\"check\">\r\n"
					+ "		</form>\r\n"
					+ "	</div>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}

//		RequestDispatcher rd = req.getRequestDispatcher("index.html");
//		rd.include(req, res);

	}

}
