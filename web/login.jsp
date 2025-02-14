<%-- 
    Document   : login
    Created on : 10/04/2020, 21:56:28
    Author     : mateu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.SQLException"%>
<%@page import="br.edu.vianna.fifa.model.dao.impl.UsuarioDAO"%>
<%@page import="br.edu.vianna.fifa.model.domain.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>FIFA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/bola.png"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100 p-l-50 p-r-50 p-t-77 p-b-30">
                    <form action="${context}/fifa" method="Post" class="login100-form validate-form">
                        <input type="hidden" name="page" value="checkLogin"/>
                        <span class="login100-form-title p-b-55">
                            Fifa 
                        </span>

                        <c:if test="${requestScope.err != null}">
                            <div class="container text-center alert alert-danger">
                                ${requestScope.err}
                            </div>
                        </c:if>

                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Valid email is required: ex@abc.xyz">
                            <input class="input100" type="text" name="login"  placeholder="Login">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <span class="lnr lnr-user"></span>
                            </span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
                            <input class="input100" type="password" name="senha" placeholder="Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <span class="lnr lnr-lock"></span>
                            </span>
                        </div>



                        <div class="container01" >
                            <div class="btn-logar-img " >
                                <button class="fa fa-futbol-o fa-4x" type="submit" id="Logar" name="Logar" alt=""></button>
                            </div>

                        </div>


                        <div class="text-center w-full p-t-40">
                            <span class="txt1">
                                Sem cadastro?
                            </span>

                            <a href="#" data-toggle="modal" data-target="#exampleModal" data-whatever="@fat">Clique aqui</a>
                        </div>

                    </form>
                </div>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal"  role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Cadastrar Jogador</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <form action="${context}/fifa" method="POST">
                                <input type="hidden" name="page" value="saveUser"/>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Nome</label>
                                        <input type="text" name="nome" class="form-control" id="input-name">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">Login</label>
                                        <input class="form-control" name="login" required="" id="input-login">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">Senha</label>
                                        <input class="form-control" name="senha" type="password" required="" id="input-login">
                                    </div>
                                    
                                    <hr class="text-white">
                                    
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">Nome do Time</label>
                                        <input class="form-control" name="nomeTime" required="" id="input-login">
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                                        <button id="Cadastrar" class="btn btn-success"  type="Submit">Cadastrar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <!-- Fim Modal -->

            </div>

        </div>




        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>

    </body>
</html>