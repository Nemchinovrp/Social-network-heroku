<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
    <%--<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">--%>
    <script src="https://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
    <spring:url value="/resources/css/style.css" var="mainCss"/>
    <%--<link href="${mainCss}" rel="stylesheet" />--%>
    <spring:url value="/resources/css/jquery-ui.css" var="ui"/>
    <link href="${ui}" rel="stylesheet"/>
    <spring:url value="/resources/js/pagination.js" var="page"/>
    <script src="${page}"></script>

</head>
<body style="background-color:#EDEEF0">
<div class="container">
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <div class="center-block">
                <h2>Результат поиска</h2>
                <h3>Всего найденно: ${total} чел</h3>
            </div>
        </div>
        <div class="col-lg-4"></div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5"></div>
                    <div class="col-lg-2" style="width:150px; margin-top:12px">
                        <div id='slider'></div>
                    </div>
                    <div class="col-lg-5">
                        <div id="num"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-1"></div>
    </div>
</div>

<div class="row" id="search-result" style="padding:170px 0"></div>
<div id="elem1" style="display: none;"><p>${accountPages}</p></div>
<div id="elem2" style="display: none;"><p>${searchString}</p></div>

<div class="container">
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <div class="center-block">
                <p>Общее количество страниц: ${accountPages}</p>
            </div>
        </div>
        <div class="col-lg-4"></div>
    </div>
</div>
</body>
</html>
