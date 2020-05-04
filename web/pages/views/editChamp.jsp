<%-- 
    Document   : editChamp
    Created on : 02/05/2020, 20:34:50
    Author     : mateu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="modal-body">
            <div class="form-group row justify-content-center">
                <div class="form-group col-md-4">
                    <label class="control-label text-white">Nome</label>
                    <input class="form-control text-center" value="${champ.nome}" readonly="">
                </div>
                <div class="form-group col-md-3">
                    <label class="control-label text-white">Times</label>
                    <input class="form-control text-center" value="${quantidade.times}" readonly="">
                </div>
                <div class="form-group col-md-4">
                    <label class="control-label text-white">Data de Inicio</label>
                    <input class="form-control text-center" type="text" value="<fmt:formatDate pattern = "dd/MM/yyyy" value = "${champ.data}" />" readonly=""/>
                </div>
            </div>
        </div>

        <hr class="text-white">

        <div class=" container-fluid border">


            <ul class="nav nav-tabs ">
                <li class="nav-item">
                    <a class="nav-link border active toggleTag" data-toggle="tab"  data-name="tabTeams" href="javascript:void()">Times</a>
                </li>
                <li>
                    <a class="nav-link border toggleTag" data-toggle="tab"  data-name="tabMatch" href="javascript:void()">Partidas</a>
                </li>
            </ul>



            <div class="row justify-content-center" id="tabTeams">

                <c:forEach items="${partidas}" var="partida" varStatus="status">
                    <div class="col-auto mt-3">
                        <div class="card text-center justify-content-center opacity-tab" style="width: 20rem; height: 10rem" >
                            <div class="card-mody text-white">
                                <h5 class="card-title">${partida.idPrimeiroTime.nome} </h5>
                                <h6>Vs</h6> 
                                <h5 class="card-title">${partida.idSegundoTime.nome}</h5>
                            </div>
                        </div>
                    </div>
                            
                </c:forEach>

            </div>

            <div class="row justify-content-center" id="tabMatch">

                <c:forEach items="${partidas}" var="partida" varStatus="status">
                    <div class="col-auto mt-3">
                        <div class="card text-center  justify-content-center opacity-tab" style="width: 20rem; height: 10rem" >
                            <div class="card-mody text-white">
                                <div class="row text-center justify-content-center">
                                    <div class="col-2 ">
                                        <h1><b>0</b></h1>
                                    </div>
                                    <c:if test="${user.nivelAcesso}">
                                    <div class="col-2 mt-2">
                                        <h5><a href="${context}/fifa?page=editMatch&id=${partida.id}"><i class="fas fa-futbol text-success"></i></a></h5>
                                    </div>
                                    </c:if>
                                    <c:if test="${!user.nivelAcesso}">
                                    <div class="col-2 mt-2">
                                        <h5>x</h5>
                                    </div>
                                    </c:if>
                                    <div class="col-2 ">
                                        <h1><b>0</b></h1>
                                    </div>
                                </div>
                            </div>
                            <div class="card-mody text-white">
                                <h5 class="card-title">${partida.idPrimeiroTime.nome} Vs ${partida.idSegundoTime.nome}</h5>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>

            


        </div>



        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    </body>
</html>
