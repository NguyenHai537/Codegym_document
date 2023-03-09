<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 2023/01/09
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>
</head>
<body>
<h1>Delete Watch</h1>
<form method="post">
  <h3>Are you sure?</h3>
  <fieldset>
    <legend>Student information</legend>
    <table>
      <tr>
        <td>ID: ${requestScope["student"].getId()} </td>
      </tr>
      <tr>
        <td>Name: ${requestScope["student"].getName()} </td>
      </tr>
      <tr>
        <td>Date of Birth: ${requestScope["student"].getDate()}</td>
      </tr>
      <tr>
        <td>Address: ${requestScope["student"].getAddress()}</td>
      </tr>
      <tr>
        <td>Phone Number: ${requestScope["student"].getPhone()}</td>
      </tr>
      <tr>
        <td>Email: ${requestScope["student"].getEmail()}</td>
      </tr>
      <tr>
        <td>Classroom: ${requestScope["student"].getClassroom()}</td>
      </tr>
      <tr>
        <td><input type="submit" value="Delete"></td>
        <td><a href="/Students">Back to product list</a></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
