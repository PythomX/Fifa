<%-- 
    Document   : editMatch
    Created on : 03/05/2020, 17:49:21
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

        <div class="card-body ">
            <div class="card ">

                <div class="card-header  bg-dark py-3">
                    <h6 class="m-1 font-weight-bold text-center text-white">Partida</h6>
                </div>

                <div class="card-body text-center align-content-center">
                    <div class="row">
                        <div class="col-md-5 text-center">
                            <p class="h1">${partida.idPrimeiroTime.nome}</p>
                        </div>
                        <div class="col-2 mt-2"><p class="h4">Vs</p></div>
                        <div class="col-md-5 text-center">
                            <p class="h1 text-center">${partida.idSegundoTime.nome}</p>
                        </div>
                    </div>
                </div>
                <div class="modal-footer justify-content-center">
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalGoal">Add Gol</button>
                    <button type="button" class="btn btn-danger">Finalizar Partida</button>
                </div>
            </div>


        </div>

        <!-- Modal -->
        <div class="modal fade" id="modalGoal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header bg-dark">
                        <h5 class="modal-title  text-white" id="exampleModalLongTitle">Adicionar Gol</h5>
                        <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="${context}/fifa" id="formAddGoal">
                        <input type="hidden" name="page" value="insertGoal">
                        <input type="hidden" name="matchId" value="${partida.id}">
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Time</label>
                                <select class="form-control" name="nomeTeam" id="time">
                                    <option value="${partida.idPrimeiroTime.nome}" data-pos="primeiro">${partida.idPrimeiroTime.nome}</option>
                                    <option value="${partida.idPrimeiroTime.nome}" data-pos="segundo">${partida.idSegundoTime.nome}</option>
                                </select>
                            </div>
                            <div class="form-group" id="jogadoresPrimeiroTime">
                                <label>Jogador</label>
                                <select class="form-control" name="jogadorId" id="primeiroSelect" >
                                    <c:forEach items="${partida.idPrimeiroTime.jogadorList}" var="jogador">
                                        <option value="${jogador.id}">${jogador.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group" id="jogadoresSegundoTime">
                                <label>Jogador</label>
                                <select class="form-control" name="jogadorId" id="segundoSelect">
                                    <c:forEach items="${partida.idSegundoTime.jogadorList}" var="jogador">
                                        <option value="${jogador.id}">${jogador.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="row">
                                <div class="col text-center">
                                    <label>Tempo</label>
                                </div>
                            </div>
                            <div class="input-group justify-content-center">
                                <input type="number" class="form-control col-md-2 text-center justify-content-center" name="tempo" value="0" required="">
                                <div class="input-group-append">
                                    <div class="input-group-text">"</div>
                                </div>
                            </div>

                        </div>

                    </form>
                    <div class="modal-footer">
                        <button type="submit" form="formAddGoal" class="btn btn-success">Adicionar</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>  
        <!-- Fim Modal-->

        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    </body>
</html>
