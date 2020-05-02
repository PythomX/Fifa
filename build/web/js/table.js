
/*----------Lista de Usuarios----------*/
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
    var actions = $("table td:last-child").html();
    // Append table with add row form on add new button click
    $(".add-new").click(function () {
        $(this).attr("disabled", "disabled");
        var index = $("table tbody tr:last-child").index();
        var row = '<tr>' +
                '<td><input type="text" class="form-control" name="nome" id="nome"></td>' +
                '<td><input type="text" class="form-control" name="login" id="login"></td>' +
                '<td><input type="text" class="form-control" name="nivelAcesso" id="nivelAcesso"></td>' +
                '<td>' + actions + '</td>' +
                '</tr>';
        $("table").append(row);
        $("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });
    // Add row on add button click
    $(document).on("click", ".add", function () {
        var empty = false;
        var input = $(this).parents("tr").find('input[type="text"]');
        input.each(function () {
            if (!$(this).val()) {
                $(this).addClass("error");
                empty = true;
            } else {
                $(this).removeClass("error");
            }
        });
        $(this).parents("tr").find(".error").first().focus();
        if (!empty) {
            input.each(function () {
                $(this).parent("td").html($(this).val());
            });
            $(this).parents("tr").find(".add, .edit").toggle();
            $(".add-new").removeAttr("disabled");
        }
    });

    $(document).on("click", ".edit", function () {
        $(this).closest('tr').find("input:not([type^=button])").each(function () {
            alert("aqui chama o nome " + this.name)
        });

    });


    // Edit row on edit button click
    $(document).on("click", ".edit", function () {
        $(this).parents("tr").find("td:not(:last-child)").each(function () {
            $(this).html('<input type="text" class="form-control" name="' + this.name + '" value="' + $(this).text() + '">');
        });
        $(this).parents("tr").find(".add, .edit").toggle();
        $(".add-new").attr("disabled", "disabled");
    });


    // Delete row on delete button click
    $(document).on("click", ".delete", function () {
        $(this).parents("tr").remove();
        $(".add-new").removeAttr("disabled");
    });
});



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


