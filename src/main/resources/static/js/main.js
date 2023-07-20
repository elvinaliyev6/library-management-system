
function refreshTable() {
    $.get("/api/books/all", function (data) {
        var tableBody = $("#tableBody");
        tableBody.empty();
        $.each(data, function (index, row) {
            tableBody.append(`<tr><td>${row.id}</td><td>${row.name}</td><td>${row.genre}</td><td>${row.author}</td></tr>`);
        });
    });
}

$(document).ready(function () {
    refreshTable();
    $("#refreshBtn").click(function () {
        refreshTable();
    });
});