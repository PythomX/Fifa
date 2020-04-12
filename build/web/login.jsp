<%-- 
    Document   : login
    Created on : 10/04/2020, 21:56:28
    Author     : mateu
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="br.edu.vianna.fifa.model.dao.impl.UsuarioDAO"%>
<%@page import="br.edu.vianna.fifa.model.domain.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <form class="login100-form validate-form" id="idform">
                        <span class="login100-form-title p-b-55">
                            Fifa 
                        </span>

                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Valid email is required: ex@abc.xyz">
                            <input class="input100" type="text" name="email"  placeholder="Email">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <span class="lnr lnr-envelope"></span>
                            </span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
                            <input class="input100" type="password" name="pass"   placeholder="Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <span class="lnr lnr-lock"></span>
                            </span>
                        </div>



                        <div class="container01" >
                            <a class="txt1 hov1" href="home.jsp">
                                <div class="btn-logar " type="submit">
                                    <input class="btn-logar-img " type=image src="images/icons/bola.png" width="50" height="50"> 
                                </div>							
                            </a>

                        </div>


                        <div class="text-center w-full p-t-40">
                            <span class="txt1">
                                Sem cadastro?
                            </span>



                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@fat">Clique aqui</button>
                        </div>

                    </form>
                    <!-- Modal -->
                </div>
                <div class="modal fade" id="exampleModal"  role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Cadastrar Jogador</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form action="CadastroUsuario" method="POST">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Nome</label>
                                        <input type="text" name="nome" class="form-control" id="input-name">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">Login</label>
                                        <input class="form-control" name="login" id="input-login">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">Senha:</label>
                                        <input class="form-control" name="senha" id="input-senha">
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                                        <button type="button" type="submit" class="btn btn-primary">Cadastrar</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>

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