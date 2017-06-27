<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-dropdown/2.0.3/jquery.dropdown.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-dropdown/2.0.3/jquery.dropdown.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/additional-methods.js"></script>

    <spring:url value="/resources/js/custom.js" var="customs"/>
    <script src="${customs}"></script>

</head>
<body style="background-color:#EDEEF0">
<div class="container" style="padding:20px 0">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <form:form id="update" class="form-horizontal" commandName="account" action="updateAccount"
                                   role="form" method="post">
                            <div id="legend">
                                <legend class="">Редактирование:</legend>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="id">id: </label>
                                <div class="controls">
                                    <input type="text" hidden="true" id="id" name="id"
                                           value="<c:out value="${account.id}"/>"
                                           placeholder="" class="form-control input-lg">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="firstName">Имя: </label>
                                <div class="controls">
                                    <input type="text" id="firstName" name="firstName"
                                           value="<c:out value="${account.firstName}"/>" placeholder=""
                                           class="form-control input-lg">
                                </div>
                            </div>
                            <div class="control-group">
                                    <%--@declare id="middleName"--%><label class="control-label" for="middleName">Отчество: </label>
                                <div class="controls">
                                    <input type="text" id="middleName" name="middleName"
                                           value="<c:out value="${account.middleName}"/>" placeholder=""
                                           class="form-control input-lg">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="lastName">Фамилия: </label>
                                <div class="controls">
                                    <input type="text" id="lastName" name="lastName"
                                           value="<c:out value="${account.lastName}"/>" placeholder=""
                                           class="form-control input-lg">
                                </div>
                            </div>
                            <div class="control-group">
                                    <%--@declare id="dateOfBirth"--%><label class="control-label" for="dateOfBirth">Дата
                                рождения: </label>
                                <div class="controls">
                                    <fmt:formatDate var="fmtDate" value="${account.dateOfBirth}" pattern="yyyy-MM-dd"/>
                                    <form:input id="date" class="form-control input-lg" type="text" path="dateOfBirth"
                                                value="${fmtDate}"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="email">E-mail</label>
                                <div class="controls">
                                    <input type="email" id="email" name="email"
                                           value="<c:out value="${account.email}"/>" placeholder=""
                                           class="form-control input-lg">
                                </div>
                            </div>
                            <div class="control-group required">
                                <label class="control-label" for="password">Пароль</label>
                                <div class="required">
                                    <input type="password" id="password" name="password" placeholder="Password"
                                           class="form-control input-lg" required="required">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="skype">Skype: </label>
                                <div class="controls">
                                    <input type="text" id="skype" name="skype"
                                           value="<c:out value="${account.skype}"/>" placeholder=""
                                           class="form-control input-lg">
                                </div>
                            </div>

                            <div class="wrapper">
                                <c:if test="${account.getPhones().size() > 0}">
                                    <label class="control-label">Телефоны: </label></br>
                                    <c:forEach varStatus="i" var="phone" items="${account.phones}">
                                        <div class="form-group">
                                            <div class="col-xs-6 col-md-5 countF">
                                                <form:select path="phones[${i.index}].phoneType" name="phoneType"
                                                             class="selectpicker form-control type">
                                                    <option value="${phone.phoneType}">${phone.phoneType}</option>
                                                    <option value="HOME">HOME</option>
                                                    <option value="WORK">WORK</option>
                                                    <option value="OTHER">OTHER</option>
                                                </form:select>
                                            </div>
                                            <div class="col-xs-6 col-md-6">
                                                <div id="phoneVal" class="pull-right"></div>
                                                <form:input path="phones[${i.index}].number" class="form-control"
                                                            name="phoneList"
                                                            type="text" value="${phone.number}" required="required"/>
                                            </div>
                                            <input type="button" class="removeField" value="-"/>
                                        </div>
                                    </c:forEach>
                                </c:if>
                            </div>
                            <button class="fieldAddButton">Add phone</button>
                            </br>

                            <a class="btn btn-lg btn-success" btn-block href="#" data-toggle="modal"
                               data-target="#basicModal">Сохранить изменения</a>
                            <div class="modal fade" id="basicModal" tabindex="-1" role="dialog">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h3>Хотите сохранить изменения?</h3>
                                        </div>
                                        <div class="control-group">
                                            <div class="controls">
                                                <div class="modal-footer">
                                                    <button class="btn btn-default" type="button"
                                                            data-dismiss="modal">Нет
                                                    </button>

                                                    <button class="btn btn-success ">Да</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </form:form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>

</body>
</html>
