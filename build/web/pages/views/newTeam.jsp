<%-- 
    Document   : newTeam
    Created on : 24/04/2020, 02:16:11
    Author     : mateu
--%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">

        <link rel="stylesheet" href="css/style.css">

        <title>Novo Time</title>
    </head>
    <body>




        <form action="${context}/fifa" method="POST">
            <input type="hidden" name="page" value="saveNewTeam"/>
            <div class="modal-body justify-content-md-center">
                <div class="form-group">
                    <label class="text-center">Nome</label>
                    <input type="text" name="nome" class="form-control col-md-3" id="input-name">
                </div>
                <div class="form-group">
                    <label for="message-text" class="col-form-label">Login</label>
                    <input class="form-control" name="login" required="" id="input-login">
                </div>
                <div class="form-group">
                    <label for="message-text" class="col-form-label ">Senha</label>
                    <input class="form-control " type="password" required="" name="senha" id="input-senha">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    <button id="Cadastrar" class="btn btn-success"  type="Submit">Cadastrar</button>
                </div>
            </div>
        </form>






        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
    </body>
</html>
