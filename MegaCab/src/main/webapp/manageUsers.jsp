<%@ page import="com.megaCab.JavaFiles.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Windows
  Date: 3/12/2025
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<User> userList = (List<User>) request.getAttribute("customers");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>User Management</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Username</th>
            <th>User Type</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
       <%
           for (User user : userList){
       %>
            <tr>
                <td><%= user.getId()%>}</td>
                <td><%= user.getName()%></td>
                <td><%= user.getEmail()%></td>
                <td><%= user.getUsername()%></td>
                <td><%= user.getUserType()%></td>
                <td>
                    <a href="${pageContext.request.contextPath}/editUser.jsp?userId=<%=user.getId()%>&name=<%=user.getName()%>&address=<%=user.getAddress()%>&nic=<%=user.getNic()%>&telephone=<%=user.getTelephone()%>&password=<%=user.getPassword()%>&email=<%=user.getEmail()%>" class="btn btn-primary btn-sm">Edit</a>

                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>