<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        <form id="update" class="form-horizontal" commandName="account" action="updateFoto"
                              role="form" enctype="multipart/form-data" method="post">
                            <h3>Изменить фото</h3>

                            <div class="control-group">
                                <%--@declare id="foto"--%><label class="control-label" for="foto">Фото: </label>
                                <div class="controls">
                                    <input type="file" id="foto" name="foto" class="form-control input-lg">
                                </div>
                            </div>


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
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>

</body>
</html>
