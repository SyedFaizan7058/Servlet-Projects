<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.bean_files.*,java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-group input[type="number"] {
            width: 96%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .btn {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            border: none;
        }

        .btn:hover {
            opacity: 0.9;
            cursor: pointer;
        }
        
        .container:hover {
            transform: translateY(-10px);
        }
    </style>
</head>
<body>
    <div class="container">
        <%
        AdminBean ab = (AdminBean) session.getAttribute("abean");
        ArrayList<ProductBean> list = (ArrayList<ProductBean>) session.getAttribute("plist");
        String pcode = request.getParameter("pcode");
        out.println("Page belongs to Admin: " + ab.getFname() + "<br><br>");

        for (ProductBean pb : list) {
            if (pcode.equals(pb.getCode())) {
        %>
        <form action="update" method="post">
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" id="price" name="price" value="<%=pb.getPrice()%>">
            </div>
            <div class="form-group">
                <label for="qty">Quantity:</label>
                <input type="number" id="qty" name="qty" value="<%=pb.getQty()%>">
            </div>
            <input type="hidden" name="pcode" value="<%=pb.getCode()%>">
            <input type="submit" class="btn" value="Edit Product">
        </form>
        <%
                break;
            }
        }
        %>
    </div>
</body>
</html>
