<%@ page import="ua.my.progect.util.TimeUtil" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>

<html>
<head>
    <title>Pages</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>

<style>
    .top-buffer { margin-top:10px; }
</style>


<div class="container">
    <h3><a href="index.html">Home</a> | Pages</h3>
    <a href="pages?action=create"><button type="button" class="btn btn-primary">Add Page</button></a>

    <table id="pages_table" class="table table-sm table-bordered top-buffer">
        <thead>
        <tr>
            <th scope="col" class="text-center">№</th>
            <th scope="col">Дата/Час</th>
            <th scope="col">User</th>
            <th scope="col">Page_name</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>

        <tbody>
        <% Integer n = 1;%>
        <c:forEach items="${pageList}" var="list">
            <jsp:useBean id="list" scope="page" class="ua.my.progect.model.Page" />
            <tr>
                <td scope="col" class="text-center"><%=n++%></td>
                <td scope="col"><%= TimeUtil.toString(list.getPageDateTime()) %></td>
                <td scope="col"><c:out value="${list.userName}"/></td>
                <td scope="col"><c:out value="${list.pageName}"/></td>
                <td scope="col"><a href="pages?action=update&id=${list.id}">Update</a></td>
                <td scope="col"><a href="pages?action=delete&id=${list.id}">Delete</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

</body>
</html>