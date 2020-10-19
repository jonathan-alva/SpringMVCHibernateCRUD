<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 10/19/2020
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Department Management Screen</title>
</head>
<body>
<div align="center">
    <h1>Department List</h1>
    <a href="./">Home</a>
    <table border="1">
        <th>Id</th>
        <th>Name</th>

        <c:forEach var="department" items="${listDepartment}">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td><a href="./department/editDepartment?id=${department.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp; <a href="./department/deleteDepartment?id=${department.id}">Delete</a>
            </td>
        <tr>
            </c:forEach>
    </table>
    <h4>
        New Department Register <a href="./department/newDepartment">here</a>
    </h4>
</div>
</body>
</html>
