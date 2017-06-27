<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <meta http-equiv="CONTENT-TYPE" content="text/html" ; charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/ui-lightness/jquery-ui.css" rel="stylesheet"
          type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

    <spring:url value="/resources/js/calendar.js" var="cus"/>
    <script src="${cus}"></script>
</head>
<body style="background-color:#EDEEF0">
<div class="container" style="padding:20px 0">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <form:form class="form-horizontal" action="create_account" method="post" commandName="account"
                                   modelAttribute="account">
                            <fieldset>
                                <div id="legend">
                                    <legend class="">Введите Ваши данные:</legend>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="firstName">Имя: </label>
                                    <div class="controls">
                                        <input type="text" id="firstName" name="firstName" placeholder=""
                                               class="form-control input-lg">
                                    </div>
                                </div>
                                <div class="control-group">
                                        <%--@declare id="middleName"--%><label class="control-label" for="middleName">Отчество: </label>
                                    <div class="controls">
                                        <input type="text" id="middleName" name="middleName" placeholder=""
                                               class="form-control input-lg">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="lastName">Фамилия: </label>
                                    <div class="controls">
                                        <input type="text" id="lastName" name="lastName" placeholder=""
                                               class="form-control input-lg">
                                    </div>
                                </div>
                                <div class="control-group">
                                        <%--@declare id="dateOfBirth"--%><label class="control-label" for="dateOfBirth">Дата
                                    рождения: </label>
                                    <div class="controls">
                                        <fmt:formatDate var="fmtDate" value="${account.dateOfBirth}"
                                                        pattern="yyyy-mm-dd"/>
                                        <form:input id="datepicker" class="form-control input-lg" type="text"
                                                    path="dateOfBirth" value="${fmtDate}"/>
                                    </div>
                                </div>


                                <div class="control-group">
                                    <label class="control-label" for="email">E-mail</label>
                                    <div class="controls">
                                        <input type="email" id="email" name="email" placeholder=""
                                               class="form-control input-lg">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="password">Пароль</label>
                                    <div class="controls">
                                        <input type="password" id="password" name="password" placeholder=""
                                               class="form-control input-lg">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="icq">Icq: </label>
                                    <div class="controls">
                                        <input type="text" id="icq" name="icq" placeholder=""
                                               class="form-control input-lg">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="skype">Skype: </label>
                                    <div class="controls">
                                        <input type="text" id="skype" name="skype" placeholder=""
                                               class="form-control input-lg">
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <button class="btn btn-success btn-block">Зарегистрироваться</button>
                                    </div>
                                </div>
                            </fieldset>
                        </form:form>

                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>

</body>
</html>