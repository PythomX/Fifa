<%-- 
    Document   : updateTeam
    Created on : 28/04/2020, 11:48:50
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


        <form action="${context}/fifa" method="POST">
            <input type="hidden" name="page" value="updateTeam"/>
            <div class="container">
                <div class="modal-body ">

                    <div class="row justify-content-center">
                        <input class="form-control col-md-8 m-4 mb-3 input-nome-time text-center " value="${time.getNome()}" name="nomeTime" placeholder="Nome do time" required="" type="text">
                    </div>

                    <c:forEach items="${time.getJogadorList()}" var="jogador">
                        <div class="m-2 text-center">
                            <input class="input-nome text-center" placeholder="Nome" value="${jogador.getNome()}" required="" type="text" name="nomeJogador[]" id="input-name">
                            <select class="col-md-2 text-center input-nome" required="" id="inputState" name="posicaoJogador[]" >
                                <c:forEach items="${posicoes}" var="posicao">
                                    <option class="text-center input-nome" value="${posicao.getPosicao()}"<c:if test="${posicao.getPosicao() == jogador.getPosicao()}">selected</c:if>>${posicao.getPosicao()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </c:forEach>

                    <hr class="text-white">

                </div>
            </div>
            <div class="text-center">
                <button class="btn btn-secondary col-md-3" id="Cadastrar" type="submit">Atualizar</button>
            </div>
        </form>




        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    </body>
</html>
