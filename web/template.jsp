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

        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!-- Bootstrap CSS CDN -->
        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="${context}/css/style.css">
        <!--===============================================================================================-->
        <!-- Scrollbar Custom CSS -->

        <!-- Font Awesome JS -->

    </head>

    <body >

        
        <nav class="navbar bg-dark nav-link ">
            <div class="container-fluid">

                <button type="button" id="sidebarCollapse" class="btn btn-info-dark bg-dark">
                    <img src="https://media.contentapi.ea.com/content/dam/ea/fifa/fifa-19/global-assets/common/logos/fifa-white.svg">
                </button>

            </div>
        </nav>

        

        <!-- Sidebar  -->
        <nav id="sidebar">
            <div id="dismiss">
                <i class="fa fa-arrow-left fa-2x"></i>
            </div>
            <!--navbar navbar-expand-lg navbar-light text-center-->
            <div class="sidebar-header">
                <li class="nav-item nav-link active text-center p-1">
                    <div class="sidebar-brand">
                        <i class="fas fa-futbol fa-3x"></i>
                    </div>
                    <h4>${sessionScope.user.nome}</h4>
                    <c:if test="${sessionScope.user.nivelAcesso == true}">
                        <h6>Administrador</h6>
                    </c:if>
                    <c:if test="${sessionScope.user.nivelAcesso != true}">
                        <h6>Player</h6>
                    </c:if>
                </li>
            </div>

            <ul class="list-unstyled sidebar-trans">
                <hr class="components">
                <li>
                    <a href="${context}/fifa?page=home" data-toggle="collapse" aria-expanded="false">
                        <i class="fas fa-house-user fa-2x"></i>
                        Home
                    </a>

                    <a href="#">
                        <i class="fa fa-trophy fa-2x"></i>
                        Campeonato
                    </a>

                    <c:if test="${user.nivelAcesso}" var="user">
                        <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false">
                            <i class="fa fa-user fa-2x"></i>
                            Administrador
                        </a>
                        <ul class="collapse list-unstyled" id="pageSubmenu">
                            <li>
                                <a  href="#">
                                    <i class="fas fa-users fa-lg"></i>Jogadores</a>
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
                    <a href="#pageSubTeam" data-toggle="collapse" aria-expanded="false">
                        <i class="fas fa-user-friends fa-2x"></i>
                        Time
                    </a>
                    <ul class="collapse list-unstyled" id="pageSubTeam">
                        <li>
                            <a href="${context}/fifa?page=newTeam"><i class="fas fa-user-plus fa-lg"></i>Novo</a>
                        </li>
                        <li>
                            <a href="#"><i class="fas fa-users-cog fa-lg"></i>Times</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-chart-line fa-2x"></i>
                        Rank
                    </a>
                </li>

                <hr class="components">

                <li>
                    <a href="#" data-toggle="modal" data-target="#myModal">
                        <i class="fas fa-sign-out-alt fa-2x"></i>
                        Sair
                    </a>
                </li>

            </ul>


        </nav>



        <div class="container-fluid h-100 d-inline-block">

            <c:catch var="ex">

                <c:if test="${param.page == null}">
                    <jsp:include page="pages/views/home.jsp" />
                </c:if>                            
                <c:if test="${param.page != null}">
                    <jsp:include page="pages/views/${param.page}.jsp" />
                </c:if>

            </c:catch>
        </div>




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
        <!--===============================================================================================-->
        


    </body>
</html>
