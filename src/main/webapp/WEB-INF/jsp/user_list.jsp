<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <table class="table table-striped">
        <thead class="thead-dark">
        <th scope="row">Id</th>
        <th scope="row">User Name</th>
        <th scope="row">First Name</th>
        <th scope="row">Last Name</th>
        <th scope="row">Cell Number</th>
        <th scope="row">Email Address</th>
        </thead>
        <tbody>

        <c:forEach items="${userSet}" var="user" >
            <tr>
                <td>${user.userId}</td>
                <td>${user.username}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.cellNo}</td>
                <td>${user.emailAddress}</td>

<%--                <td>--%>
<%--                    <spring:url value="/student/editStudent/${student.id}" var="editURL" />--%>
<%--                    <a class="btn btn-info" href="${editURL}" role="button" >Update</a>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <spring:url value="/student/deleteStudent/${student.id}" var="deleteURL" />--%>
<%--                    <a class="btn btn-danger" href="${deleteURL}" role="button" >Delete</a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<%--    <spring:url value="/student/addStudent/" var="addURL" />--%>
<%--    <a class="btn btn-success" href="${addURL}" role="button" >Add New Student</a>--%>
</div>
</body>
</html>