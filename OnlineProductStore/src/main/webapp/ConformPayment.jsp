<%@page import="com.email.EmailNotification"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.bean_files.*,java.util.*,com.dao_files.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Page</title>
</head>
<body>

	<%
	HttpServletRequest req = null;
	HttpServletResponse res = null;

	try {
		ProductBean pb = (ProductBean) session.getAttribute("pl");
		UserBean ub = (UserBean) session.getAttribute("ubean");
		// Taking request parameter
		req = (HttpServletRequest) this.getServletContext().getAttribute("req");
		res = (HttpServletResponse) this.getServletContext().getAttribute("res");
		String pqty = (String) this.getServletContext().getAttribute("qty");

		if (pqty != null || pqty != "") {
			int qty = Integer.parseInt(pqty);
			if (qty <= pb.getQty() && qty != 0) {
		pb.setQty(pb.getQty() - (qty));

		int k = new PurchaseProductDAO().purchase(pb);
		if (k > 0) {
			try {
				EmailNotification.sendNotification(ub.getMid(), "Paymnet Confirmed!!",
						"Your Order For " + pb.getName() + " is Placed Successfully...");
				out.println("Order Placed Successfully...<br>");
				out.println("Payment Confirmd...<br>");
			} catch (Exception e) {
				request.setAttribute("msg", "Product Canceld...<br>");
				request.getRequestDispatcher("ProductNotAvailable.jsp").forward(request, response);
			}
		}

			} else {
		req.setAttribute("msg", "Product is Out of Stock...<br>");
		req.getRequestDispatcher("ProductNotAvailable.jsp").forward(req, res);
			}
		}

	} catch (NullPointerException e) {
		req.setAttribute("msg", "You Have to Login First...<br>");
		req.getRequestDispatcher("ProductNotAvailable.jsp").forward(req, res);
	}
	%>

	<a href="ViewAllProduct2.jsp"><input type="submit" value="Back"></a>

</body>
</html>