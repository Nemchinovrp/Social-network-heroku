$(document).ready(function () {

    var page = $("#elem1").text();
    var search = $("#elem2").text();
    $("#slider").slider({
        step: 1,
        min: 1,
        max: page,

        stop: function (event, ui) {
            $("#num").html("<span>" + "Текущая страница: " + ui.value + "</span>");
            $.ajax({
                url: window.location.origin + '/getPage',
                type: 'GET',
                data: "page=" + ui.value + "&search=" + search,
                dataType: 'json',
                success: function (data) {
                    $('#search-result').empty(),
                        $.each(data, function (index, value) {
                            $("#search-result").append('<div class="col-sm-3">' +
                                '<div class="card text-center">' +
                                '<div class="card hovercard">' +
                                '<div class="cardheader">' +
                                '</div>' +
                                ' <div class="avatar">' +
                                '<img width="450" height="465" src="data:image/png;base64,' + value.foto + '">' +
                                '</div>' +
                                '<div class="info">' +
                                '<div class="desc">' + value.firstName + '</div>' +
                                '<div class="desc">' + value.lastName + '</div>' +
                                '<div class="desc">' + value.email + '</div>' +
                                '</div>' +
                                '</div>' +
                                '</div>' +
                                '</div>');
                        });
                }
            });
        },
        create: function (event, ui) {
            $("#num").html("<span>" + "Текущая страница: " + 1 + "</span>");
            $.ajax({
                url: window.location.origin + '/getPage',
                type: 'GET',
                data: "page=" + 1 + "&search=" + search,
                dataType: 'json',
                success: function (data) {
                    $.each(data, function (index, value) {
                        $("#search-result").append(
                            '<div class="col-sm-3">' +
                            '<div class="card text-center">' +
                            '<div class="card hovercard">' +
                            '<div class="cardheader">' +
                            '</div>' +
                            ' <div class="avatar">' +
                            '<img width="450" height="465" src = "data:image/png;base64,' + value.foto + '">' +
                            '</div>' +
                            '<div class="info">' +
                            '<div class="desc">' + value.firstName + '</div>' +
                            '<div class="desc">' + value.lastName + '</div>' +
                            '<div class="desc">' + value.email + '</div>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</div>');
                    });
                }
            });
        }
    });
});