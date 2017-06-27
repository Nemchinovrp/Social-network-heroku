<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<table class="table table-bordered table-hover">
    <thead class="thead-inverse">
    <tr>
        <th>Id</th>
        <th>Image</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    </thead>
    <c:forEach items="${friends}" var="account">
        <tr>
            <td>${account.id}</td>
            <td>
                <img src="${pageContext.servletContext.contextPath }/photo?email=${account.email}" width="50"
                     height="65"/>
            </td>
            <td>${account.firstName}</td>
            <td>${account.lastName}</td>
            <td>${account.email}</td>
            <td>
                <a href="viewAccount?action=display&email=<c:out value="${account.email}"/>">Посмотреть</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
