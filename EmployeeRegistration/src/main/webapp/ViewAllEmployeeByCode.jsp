<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.test.EmployeeBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee By Code</title>
</head>
<body>

	<%
	ArrayList<EmployeeBean> list = (ArrayList<EmployeeBean>) request.getAttribute("list");

	if (list.size() == 0) {
		out.println("Invalid Book Code");
	} else {
	%>
	<table border="1">
		<tr>
			<th>EmpId</th>
			<th>EmpName</th>
			<th>EmpSalary</th>
			<th>EmpAddr</th>
			<th>EmpMailId</th>
			<th>EmpPhno</th>
		</tr>
		<%
		Iterator<EmployeeBean> it = list.iterator();
		if (it.hasNext()) {
			EmployeeBean b = it.next();
		%>
		<tr>
			<td><%=b.getEmpId()%></td>
			<td><%=b.getEmpName()%></td>
			<td><%=b.getEmpSalary()%></td>
			<td><%=b.getEmpAddr()%></td>
			<td><%=b.getEmpMailId()%></td>
			<td><%=b.getEmpPhno()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	out.println("<br>");
	%>

	<%@include file="choice.html"%>

</body>
</html>