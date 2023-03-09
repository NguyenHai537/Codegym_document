<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2022/12/29
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<h1> Information Product</h1>
<p>
    <a href="/Products">Back to customer List</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td>${requestScope["product"].getId()}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>${requestScope["product"].getDescription()}</td>
            </tr>
            <tr>
                <td>Maker: </td>
                <td>${requestScope["product"].getMaker()}</td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
