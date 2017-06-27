<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="col-lg-12">
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
            <c:forEach items="${result}" var="account">
                <tr>
                    <td>${account.id}</td>
                    <td>
                        <c:choose>
                            <c:when test="${account.foto != null}">
                                <div>
                                    <img src="${pageContext.servletContext.contextPath }/photo?email=${account.email}"
                                         width="50"
                                         height="65"/></br>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/resources/image/default.jpg"
                                     class="img-responsive" width="50"
                                     height="65">
                            </c:otherwise>
                        </c:choose>
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
        <div class="col-lg-3"></div>
        <div class="col-lg-2"></div>
        <div class="col-lg-2">
            <ul class="pagination">
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
            </ul>
        </div>
        <div class="col-lg-2"></div>
        <div class="col-lg-3"></div>
    </div>
    <%--  <div class="col-lg-6">
          <table class="table table-bordered table-hover">
              <thead class="thead-inverse">
              <tr>
                  <th>Id</th>
                  <th>Image</th>
                  <th>Name</th>
                  <th>Info</th>
              </tr>
              </thead>
              <c:forEach items="${groups}" var="group">
                  <tr>
                      <td>${group.id}</td>
                      <td>
                          <img src="<c:url value="logo?id=${group.id}"/>"
                               width="50"
                               height="65"/>
                      </td>
                      <td>${group.name}</td>
                      <td>${group.info}</td>
                  </tr>
              </c:forEach>
          </table>
      </div>--%>
</div>
</body>
</html>
