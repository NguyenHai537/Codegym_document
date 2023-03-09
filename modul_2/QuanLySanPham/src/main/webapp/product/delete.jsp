<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2022/12/29
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID: ${requestScope["product"].getId()} </td>
            </tr>
            <tr>
                <td>Name: ${requestScope["product"].getName()} </td>
            </tr>
            <tr>
                <td>Price: ${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Description: ${requestScope["product"].getDescription()}</td>
            </tr>
            <tr>
                <td>Maker: ${requestScope["product"].getMaker()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/Products">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
    <c:if test="${requestScope['message'] !=null}">
        <script>
            alert("Successful deleted")
        </script>
    </c:if>
</form>
</body>
</html>
