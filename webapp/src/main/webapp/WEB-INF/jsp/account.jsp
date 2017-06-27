<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-dropdown/2.0.3/jquery.dropdown.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <%@include file="action.jsp" %>

    <spring:url value="/resources/js/search.js" var="searchs"/>
    <script src="${searchs}"></script>

</head>
<body style="background-color:#EDEEF0">
<div class="container" style="padding:80px 0">
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-2">
            <div>
                <c:choose>
                    <c:when test="${account.foto != null}">
                        <div>
                            <img src="${pageContext.servletContext.contextPath }/photo?email=${account.email}"
                                 width="170"
                                 height="245"/></br>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <img src="${pageContext.request.contextPath}/resources/image/default.jpg"
                             class="img-responsive" width="170"
                             height="245">
                    </c:otherwise>
                </c:choose>
            </div>
            <form action="changeFotoAction">
                <button class="btn btn-info" btn-block>Поменять фото</button>
            </form>
            <form action="exportXml">
                <button class="btn btn-info" btn-block>Экспорт в xml</button>
            </form>
            <form action="importXml">
                <button class="btn btn-info" btn-block>Импорт из xml</button>
            </form>
        </div>
        <div class="col-lg-4">
            <table class="table">
                <tbody>
                <tr>
                    <td>Id</td>
                    <td><c:out value="${account.id}"/></td>
                </tr>
                <tr>
                    <td>First name</td>
                    <td><c:out value="${account.firstName}"/></td>
                </tr>
                <tr>
                    <td>Middle name</td>
                    <td><c:out value="${account.middleName}"/></td>
                </tr>
                <tr>
                    <td>Last name</td>
                    <td><c:out value="${account.lastName}"/></td>
                </tr>
                <tr>
                    <td>Date of Birth</td>
                    <td><fmt:formatDate value="${account.dateOfBirth}" pattern="yyyy-MM-dd"/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><c:out value="${account.email}"/></td>
                </tr>
                <tr>
                    <td>Skype</td>
                    <td><c:out value="${account.skype}"/></td>
                </tr>
                <tr>
                    <td>Phones</td>
                    <c:forEach items="${account.phones}" var="phone">
                        <table class="table">
                            <tbody>
                            <tr>
                                <td>${phone.phoneType}</td>
                                <td>${phone.number} </td>
                            </tr>
                            </tbody>
                        </table>
                    </c:forEach>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>

</body>
</html>