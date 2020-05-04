
(function ($) {
    "use strict";


    /*==================================================================
     [ Focus Contact2 ]*/
    $('.input100').each(function () {
        $(this).on('blur', function () {
            if ($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })
    })


    /*==================================================================
     [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit', function () {
        var check = true;

        for (var i = 0; i < input.length; i++) {
            if (validate(input[i]) == false) {
                showValidate(input[i]);
                check = false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function () {
        $(this).focus(function () {
            hideValidate(this);
        });
    });

    function validate(input) {
        if ($(input).attr('senha') < 6 || $(input).attr('senha') == "") {
            return false;
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }



})(jQuery);

/*---------------------------------------Tela Cadastro-------------------------------------*/
$('#exampleModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget); // Botão que acionou o modal
    var recipient = button.data('whatever'); // Extrai informação dos atributos data-*
    // Se necessário, você pode iniciar uma requisição AJAX aqui e, então, fazer a atualização em um callback.
    // Atualiza o conteúdo do modal. Nós vamos usar jQuery, aqui. No entanto, você poderia usar uma biblioteca de data binding ou outros métodos.
    var modal = $(this);
    modal.find('.modal-title').text('Nova mensagem para ' + recipient);
    modal.find('.modal-body input').val(recipient);
});

$(document).ready(function () {
    $('#sucessPopup').modal('show');
});

$(document).ready(function () {
    $('#erroCadPopup').modal('show');
});

/*----------Home----------*/

$(document).ready(function () {
    // SideNav Initialization
    $(".button-collapse").sideNav();
    new WOW().init();
});

$(document).ready(function () {
    $("#sidebar").mCustomScrollbar({
        theme: "minimal"
    });

    $('#dismiss, .overlay').on('click', function () {
        $('#sidebar').removeClass('active');
        $('.overlay').removeClass('active');
    });

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').addClass('active');
        $('.overlay').addClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });
});

/*---------------------------------------Tela Atualizar Usuario-------------------------------------*/


$(document).ready(function () {
    $('#sucessPopup').modal('show');
});

$(document).ready(function () {
    $('#erroCadPopup').modal('show');
});



$('#attUser').on('show.bs.modal', function (event) {

    var button = $(event.relatedTarget);
    var id = button.data('id');
    var nome = button.data('nome');
    var login = button.data('login');
    var senha = button.data('senha');

    var modal = $(this);

    modal.find('#id').val(id);
    modal.find('#nome').val(nome);
    modal.find('#login').val(login);
    modal.find('#senha').val(senha);
});

$('.delete').on("click", function (event) {
    
    $(this).parents("tr").remove();
    
});

$('#modalGoal').modal('handleUpdate').on('shown.bs.modal');

$(document).ready(function(){
   
    var jogadoresPrimeiroTime = $('#jogadoresPrimeiroTime');
    var jogadoresSegundoTime = $('#jogadoresSegundoTime');
    var primeiroSelect = $('#primeiroSelect');
    var segundoSelect = $('#segundoSelect');
    
    primeiroSelect.prop('disable', true);
    jogadoresSegundoTime.hide();
    
    $('#time').change(function(){
        
      var selecionado = $(this).children('option:selected').data('pos');
        if (selecionado === 'primeiro'){
            jogadoresPrimeiroTime.show();
            primeiroSelect.prop('disable', false);
            
            jogadoresSegundoTime.hide();
            segundoSelect.prop('disable', true);
        } else{
            jogadoresPrimeiroTime.hide();
            primeiroSelect.prop('disable', true);
            
            jogadoresSegundoTime.show();
            segundoSelect.prop('disable', false);
        }
        
    });
        
    
});