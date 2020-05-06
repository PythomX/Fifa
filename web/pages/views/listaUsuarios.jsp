<%-- 
    Document   : jogadores
    Created on : 25/04/2020, 18:11:33
    Author     : mateu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <title>JSP Page</title>
    </head>
    <body>

        <div class="modal-body ">
            <table id="tableUser" class="table table-striped table-bordered table-dark ">
                <thead class="thead-white col-md-1">
                    <tr>
                        <th scope="col">#Id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Login</th>
                        <th scope="col">Nivel de Acesso</th>
                    </tr>
                </thead>
                <c:forEach items="${users}" var="user" >

                    <tbody>
                        <tr class="text-center ">
                            <th id="id">${user.getId()}</th>
                            <td id="nome">${user.getNome()}</td>
                            <td id="login">${user.getLogin()}</td>
                            <c:if test="${user.getNivelAcesso()}">
                                <td id="nivelAcesso">Administrador</td>
                            </c:if>
                            <c:if test="${user.getNivelAcesso() != true}">
                                <td id="nivelAcesso">Player</td>
                            </c:if>
                                <td >
                                <a class="attUser" id="user" data-id="${user.getId()}"
                                   data-nome="${user.getNome()}" data-login="${user.getLogin()}"
                                   data-senha="${user.getSenha()}"title="Edit" data-toggle="modal" data-target="#attUser" ><i class="fas fa-edit p-1" ></i></a>
                                   <a class="delete" title="Delete"  href="${context}/fifa?page=deleteUser&id=${user.getId()}"><i class="fas fa-trash text-danger p-1"></i></a>
                            </td>

                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="attUser"  role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header bg-dark">
                        <h5 class="modal-title text-white" id="modalTitle">Atualizar Usuario</h5>
                        <button type="button" class="close text-white" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    
                    
                    <form action="${context}/fifa" method="POST">
                        <input type="hidden" name="page" value="updateUser">
                        <input type="hidden" id="id" name="id">
                        <div class="modal-body">
                            <div class="form-group row justify-content-center">
                                <label class="control-label mr-1" for="recipient-name">Nome</label>
                                <input class="form-control col-md-4 text-center" type="text" name="nome" required="" id="nome">
                                <label class="control-label ml-2 mr-1" for="message-text">Login</label>
                                <input class="form-control col-md-4 text-center" type="text" name="login" required=""  id="login">
                            </div>
                            <div class="form-group row justify-content-center">
                                <label class="control-label mr-1" for="recipient-name" >Senha</label>
                                <input class="form-control col-md-4 text-center" type="password" id="senha" name="senha" required="">
                                <select class=" form-control col-md-5 ml-3 mr-1 text-center" id="nivelAcesso" name="nivelAcesso">
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




        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <script src="js/main.js" type="text/javascript" ></script>
        <!--===============================================================================================-->
        


    </body>
</html>
