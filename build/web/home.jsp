<%-- 
    Document   : home
    Created on : 10/04/2020, 21:56:46
    Author     : mateu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

        <!-- Bootstrap CSS CDN -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

        <!-- Font Awesome JS -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

    </head>

    <body>

        <div class="wrapper">

            <!-- Page Content  -->
            <div id="content">

                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <div class="container-fluid">

                        <button type="button" id="sidebarCollapse" class="btn btn-info-dark bg-dark">
                            <img src="https://media.contentapi.ea.com/content/dam/ea/fifa/fifa-19/global-assets/common/logos/fifa-white.svg">
                        </button>
                        <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fas fa-align-justify"></i>
                        </button>

                    </div>
                </nav>

            </div>

            <!-- Sidebar  -->
            <nav class="bg-dark " id="sidebar">
                <div id="dismiss">
                    <i class="fas fa-arrow-left"></i>
                </div>

                <div class="sidebar-header ">
                    <li class="nav-item nav-link active">
                        <h3>${sessionScope.user.nome}</h3>
                    </li>
                </div>

                <ul class="list-unstyled sidebar-trans">
                    
                    <li>
                        <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false">
                            <img class="p-1 " src="images/icons/home.png"> 
                            Home
                        </a>
                    
                        <a href="#">
                            <img class="p-1 " src="images/icons/champion.png">
                            Campeonato
                        </a>
                        
                        <c:if test="${user.nivelAcesso}" var="user">
                        <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false">
                            <img class="p-1 " src="images/icons/user.png">
                            Administrador
                        </a>
                        <ul class="collapse list-unstyled" id="pageSubmenu">
                            <li>
                                <a href="#">Jogadores</a>
                            </li>
                            <li>
                                <a href="#">ADM 2</a>
                            </li>
                            <li>
                                <a href="#">ADM 3</a>
                            </li>
                        </ul>
                        </c:if>
                        
                    </li>
                    <li>
                        <a href="#">
                            <img class="p-1 " src="images/icons/team.png">
                            Time
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img class="p-1 " src="images/icons/ranking.png">
                            Rank
                        </a>
                    </li>

                    <hr class="components">
                    
                    <li>
                        <a href="#" data-toggle="modal" data-target="#myModal">
                            <img class="p-1 " src="images/icons/logout.png">
                            Sair
                        </a>
                    </li>

                </ul>





            </nav>


            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Atenção</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form>
                            <div class="modal-body">
                                Deseja sair do Sistema?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
                                <a class="btn btn-danger" href="${context}/fifa?page=logout">Sim</a>
                            </div>
                        </form>

                    </div>
                </div>
            </div>


        </div>

        <div class="overlay"></div>

        
        
        
        
        
        
        
        
        <!-- jQuery CDN - Slim version (=without AJAX) -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <!-- Popper.JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
        <!-- jQuery Custom Scroller CDN -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

        <script src="js/main.js" type="text/javascript" ></script>
        
        
    </body>
</html>
