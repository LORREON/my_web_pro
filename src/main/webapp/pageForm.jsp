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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>


<div class="container">
    <h3><a href="index.html">Home</a> | ${param.action == 'create' ? 'Create page' : 'Edit page'}</h3>


    <jsp:useBean id="npage" scope="request" class="ua.my.progect.model.Page" />
    <form method="post" action="pages">
        <div class="row">
            <div class="col-2"><input type="number" value="${npage.id}" name="id" class="form-control" placeholder="Id" readonly></div>
            <div class="col"><input type="text" value="${npage.pageName}" name="pageName" class="form-control" placeholder="Page name"></div>
            <div class="col"><input type="text" value="${npage.userName}" name="userName" class="form-control" placeholder="User name"></div>
            <div class="col"><input type="datetime-local" value="${npage.pageDateTime}" name="pageDateTime" class="form-control" ></div>
        </div>
        <br>
        <div class="row">
            <div class="col">
                <textarea name="text" class="form-control" rows="10">${npage.text}</textarea>
            </div>
        </div>
        <br>
        <div class="row">

            <div class="col">
                <button type="submit" class="btn btn-success">Save</button>
                <button type="button" class="btn btn-primary" onclick="window.history.back()">Cancel</button>
            </div>
        </div>

    </form>

</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>
<script src="/resources/tinymce/tinymce.min.js"></script>
<script>tinymce.init({ selector:'textarea', plugins:'link image code codesample'});</script>



</body>
</html>