<%-- 
    Document   : updateUser
    Created on : 27/04/2020, 11:09:22
    Author     : mateu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
       <!-- Modal -->
        <div class="modal fade" id="attUser"  role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalTitle">Atualizar Jogador</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    
                    
                    <form action="${context}/fifa" method="POST">
                        <input type="hidden" name="page"  value="updateUser&id=${user.getId()}">

                        <div class="modal-body">
                            <div class="form-group text-center">
                                <label class="control-label" for="recipient-name">Nome</label>
                                <input class="col-md-4" type="text" name="nome" required="" id="nome">
                                <label class="control-label offset-1" for="message-text">Login</label>
                                <input class="col-md-4" type="text" name="login" required=""  id="login">
                            </div>
                            <div class="form-group text-center">
                                <label class="control-label" for="recipient-name" >Senha</label>
                                <input class="col-md-4" type="password" id="senha" name="senha" required="">
                                <select class="col-md-5 offset-1" id="nivelAcesso" name="nivelAcesso">
                                    <option value="Administrador">Administrador</option>
                                    <option value="Player">Player</option>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                                <button id="Cadastrar" class="btn btn-success"  type="Submit">Atualizar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Fim Modal -->
        
        
    </body>
</html>
