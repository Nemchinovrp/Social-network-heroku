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
        <th>Name</th>
        <th>Info group</th>
        <%--<th>Action</th>--%>
    </tr>
    </thead>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.id}</td>
            <td>
                <img src="${pageContext.servletContext.contextPath }/logo?id=${group.id}" width="50"
                     height="65"/>
            </td>
            <td>${group.name}</td>
            <td>${group.info}</td>
                <%-- <td>
                     <a href="SearchResultController.do?action=display&email=<c:out value="${group.email}"/>">Посмотреть</a>
                 </td>--%>

        </tr>
    </c:forEach>
</table>
</body>
</html>
