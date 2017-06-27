$(document).ready(function () {
    var maxFieldsCount = 5;
    var count = 1;
    var fieldsWrapper = $(".wrapper");
    var addButton = $(".fieldAddButton");
    var index = $(".countF").length;

    $(addButton).click(function (e) {
        e.preventDefault();
        if (count < maxFieldsCount) {
            $(fieldsWrapper).append('<div class="form-group">' +
                ' <div class="col-xs-6 col-md-5">' +
                '<select id="phones[' + index + '].phoneType"  name="phones[' + index + '].phoneType" class="selectpicker form-control type">' +
                '<option value="HOME">HOME</option>' +
                '<option value="WORK">WORK</option>' +
                ' <option value="OTHER">OTHER</option>' +
                '</select>' +
                '</div>' +
                '<div class="col-xs-6 col-md-6">' +
                '<div id="phoneVal" class="pull-right"></div>' +
                '<input class="form-control" id="phones[' + index + '].number"  name="phones[' + index + '].number" placeholder="Phone number" type="text" required="required" pattern="[0-9]{11}"/>' +
                '</div><input type="button" class="removeField" value="-"/></div></div>');

            index++;
            count++;
            // alert(index);
        }
    });

    $(fieldsWrapper).on("click", ".removeField", function (e) {
        e.preventDefault();
        $(this).parent("div").remove();
        count--;
    });
});

$(document).ready(function () {
    $("#update").validate({
        rules: {
            firstName: {
                required: true,
                minlength: 4,
                maxlength: 16
            },
            middleName: {
                required: true,
                minlength: 4,
                maxlength: 16
            },
            lastName: {
                required: true,
                minlength: 4,
                maxlength: 16
            },
            password: {
                required: true,
                minlength: 2,
                maxlength: 16
            },
            skype: {
                required: true,
                minlength: 2,
                maxlength: 16
            },
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            firstName: {
                required: "Это поле обязательно для заполнения",
                minlength: "Имя должно быть минимум 4 символа",
                maxlength: "Максимальное число символо - 16"
            },
            middleName: {
                required: "Это поле обязательно для заполнения",
                minlength: "Отчество должно быть минимум 4 символа",
                maxlength: "Максимальное число символо - 16"
            },
            lastName: {
                required: "Это поле обязательно для заполнения",
                minlength: "Фамилия должна быть минимум 4 символа",
                maxlength: "Максимальное число символо - 16"
            },
            password: {
                required: "Это поле обязательно для заполнения",
                minlength: "Пароль должен быть минимум 6 символа",
                maxlength: "Пароль должен быть максимум 16 символов"
            },
            skype: {
                required: "Это поле обязательно для заполнения",
                minlength: "Скайп должен быть минимум 2 символа",
                maxlength: "Скайп должен быть максимум 16 символов"
            },
            email: {
                required: "Это поле обязательно для заполнения"
            }
        }
    });
});
