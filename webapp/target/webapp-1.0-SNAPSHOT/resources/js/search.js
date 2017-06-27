$(document).ready(function () {
    $("#search").autocomplete({
        source: function (request, response) {
            $.ajax({
                url: window.location.origin + '/searchAjax',
                data: {
                    search: request.term
                },
                success: function (data) {
                    response($.map(data, function (account, i) {
                        return {
                            valueEmail: account.email,
                            valueId: account.id,
                            value: ' ',
                            label: account.firstName + ' ' + account.lastName
                        }
                    }));
                }
            });
        },
        minLength: 1,
        select: function (event, ui) {
            window.location.href = window.location.origin + "/" + ui.item.valueId + "/view";
        }
    });
});