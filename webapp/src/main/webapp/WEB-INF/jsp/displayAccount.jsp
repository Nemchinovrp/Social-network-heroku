<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body style="background-color:#EDEEF0">
<%@include file="homeBar.jsp" %>
<div class="row">
    <div class="col-lg-4"></div>
    <div class="col-lg-4">
        <table class="table">
            <tbody>
            <td>
                <img src="${pageContext.servletContext.contextPath }/photo?email=${displayAccount.email}"
                     width="150"
                     height="175"/>
            </td>
            <tr>
                <td>Id</td>
                <td><c:out value="${displayAccount.id}"/></td>
            </tr>
            <tr>
                <td>First name</td>
                <td><c:out value="${displayAccount.firstName}"/></td>
            </tr>
            <tr>
                <td>Last name</td>
                <td><c:out value="${displayAccount.lastName}"/></td>
            </tr>
            <tr>
                <td>Date of Birth</td>
                <td><c:out value="${displayAccount.dateOfBirth}"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><c:out value="${displayAccount.email}"/></td>
            </tr>
            <tr>
                <td>Skype</td>
                <td><c:out value="${displayAccount.skype}"/></td>
            </tr>

            </tbody>
        </table>
    </div>
    <div class="col-lg-4"></div>
</div>
</body>
</html>
