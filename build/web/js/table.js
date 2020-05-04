
/*----------Lista de Usuarios Champ----------*/
$(".table-selectable-multiple tr").click(function (e) {
    if ($(this).hasClass('selected')) {
        $(this).removeClass("selected");
        $(this).find("input[type='checkbox']").prop('checked', false);
    } else {
        $(this).addClass("selected");
        $(this).find("input[type='checkbox']").prop('checked', true);
    }

});


$(document).ready(function () {
    $('.table tr').click(function () {
        $trClass = $(this).attr('class');
        if ($(this).hasClass('clicado')) {
            $(this).attr('class', 'desclicado');
            $(this).find("input[type='checkbox']").prop('checked', false);
        } else {
            $(this).attr('class', 'clicado');
        }
    });
});

function userToChamp()
{
    var tableUser = document.getElementById("tableUser"),
            tableChamp = document.getElementById("tableChamp"),
            checkboxes = document.getElementsByName("select1");
    for (var i = 0; i < checkboxes.length; i++)
        if (checkboxes[i].checked)
        {

            // Cria as linhas e células
            var newRow = tableChamp.insertRow(tableChamp.length),
                    cell1 = newRow.insertCell(0),
                    cell2 = newRow.insertCell(1),
                    cell3 = newRow.insertCell(2),
                    cell4 = newRow.insertCell(3);

            // Adiciona os valores
            cell1.innerHTML = "<input type='checkbox' name='select2'>";
            cell2.innerHTML = tableUser.rows[i + 1].cells[1].innerHTML;
            cell3.innerHTML = tableUser.rows[i + 1].cells[2].innerHTML;
            cell4.innerHTML = tableUser.rows[i + 1].cells[3].innerHTML;

            // Remove da tabela anterior
            var index = tableUser.rows[i + 1].rowIndex;
            tableUser.deleteRow(index);
            // O tamanho mudou, foi retirado 1
            i--;
        }
}

function champToUser()
{
    var tableUser = document.getElementById("tableUser"),
            tableChamp = document.getElementById("tableChamp"),
            checkboxes = document.getElementsByName("select2");
    console.log("Val1 = " + checkboxes.length);
    for (var i = 0; i < checkboxes.length; i++)
        if (checkboxes[i].checked)
        {
            var newRow = tableUser.insertRow(tableUser.length),
                    cell1 = newRow.insertCell(0),
                    cell2 = newRow.insertCell(1),
                    cell3 = newRow.insertCell(2),
                    cell4 = newRow.insertCell(3);
            cell1.innerHTML = "<input type='checkbox' name='select1'>";
            cell2.innerHTML = tableChamp.rows[i + 1].cells[1].innerHTML;
            cell3.innerHTML = tableChamp.rows[i + 1].cells[2].innerHTML;
            cell4.innerHTML = tableChamp.rows[i + 1].cells[3].innerHTML;

            var index = tableChamp.rows[i + 1].rowIndex;
            tableChamp.deleteRow(index);
            i--;
        }
}

$(document).ready(function () {

    var tabTeams = $("#tabTeams");
    var tabMatch = $("#tabMatch");

    tabMatch.hide();

    $('.toggleTag').click(function () {

        var name = $(this).data('name');
        if (name === "tabTeams") {
            tabMatch.hide();
            tabTeams.show();
        } else {
            tabTeams.hide();
            tabMatch.show();
        }


    });

});
