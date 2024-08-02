<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bean_files.ProductBean" %> 
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Shopping Cart</h2>
    <table>
        <tr>
            <th>Product Code</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        <% ArrayList<ProductBean> cart = (ArrayList<ProductBean>) request.getAttribute("cart"); %>
        <% if (cart != null) { %>
            <% for (ProductBean item : cart) { %>
                <tr>
                    <td><%= item.getCode() %></td>
                    <td><%= item.getName() %></td>
                    <td><%= item.getPrice() %></td>
                    <td><%= item.getQty() %></td> 
                </tr>
            <% } %>
        <% } %>
    </table>
</body>
</html>
