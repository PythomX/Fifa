<%-- 
    Document   : updateTeam
    Created on : 28/04/2020, 11:48:50
    Author     : mateu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <form action="${context}/fifa" method="POST">
            <input type="hidden" name="page" value="saveNewTeam"/>
            <div class="modal-body ">

                    <div class="form-group text-center">
                        <input class="form-control input-nome-time text-center col-md-4 offset-4" value="${time.getNome()}" name="nomeTime" placeholder="Nome do time" required="" type="text">
                    </div>
                
                <div class="form-group ">
                    <c:forEach items="${time.getJogadorList()}" var="jogador">
                        <div class="form-row p-1">
                            <input class="input-nome text-center" placeholder="Nome" value="${jogador.getNome()}" required="" type="text" name="nomeJogador[]" id="input-name">
                            <select class="col-md-1 input-nome" required="" id="inputState" name="posicaoJogador[]" >
                                <option selected disabled hidden>${jogador.getPosicao()}</option>
                                <c:forEach items="${posicoes}" var="posicao">
                                    <option value="${posicao.getPosicao()}">${posicao.getPosicao()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </c:forEach>
                </div>

                <hr class="text-white">

            </div>
            <div class="text-center">
                <button class="btn btn-secondary col-md-3"  type="Submit">Atualizar</button>
            </div>
            <br>
        </form>

    </body>
</html>
