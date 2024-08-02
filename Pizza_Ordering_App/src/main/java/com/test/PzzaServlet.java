package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order")
@SuppressWarnings("serial")
public class PzzaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
        String name = req.getParameter("name");
        String crust = req.getParameter("crust");
        String[] toppings = req.getParameterValues("top");
        String appetizer = req.getParameter("appetizer");
        String address = req.getParameter("address");
        String creditCard = req.getParameter("credit_card");
        String creditCardNumber = req.getParameter("cno");
        String repeatCreditCardNumber = req.getParameter("repeat_cno");

        req.setAttribute("name", name);
        req.setAttribute("crust", crust);
        req.setAttribute("toppings", toppings);
        req.setAttribute("appetizer", appetizer);
        req.setAttribute("address", address);
        req.setAttribute("creditCard", creditCard);
        req.setAttribute("creditCardNumber", creditCardNumber);
        req.setAttribute("repeatCreditCardNumber", repeatCreditCardNumber);

        req.getRequestDispatcher("orderDetails.jsp").forward(req, res);
    }
}
