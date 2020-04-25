<%-- 
    Document   : newTeam
    Created on : 24/04/2020, 02:16:11
    Author     : mateu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        

        <title>Novo Time</title>
    </head>

    <form action="${context}/fifa" method="POST">
        <input type="hidden" name="page" value="saveNewTeam"/>
        <div class="modal-body ">

            <div class="form-group text-center">
                <input class="form-control input-nome-time text-center col-md-4 offset-4" name="nomeTime" placeholder="Nome do time" required="" type="text">
            </div>

            <div class="form-group ">
                <% for (int i = 0; i < 11; i++) { %>
                <div class="form-row p-1">
                    <input class="input-nome text-center" placeholder="Nome" required="" type="text" name="nomeJogador[]" id="input-name">
                    <select class="col-md-1 input-nome" required="" id="inputState" name="posicaoJogador[]" >
                        <option selected disabled hidden>Posição</option>
                        <c:forEach items="${posicoes}" var="posicao">
                            <option value="${posicao.getPosicao()}">${posicao.getPosicao()}</option>
                        </c:forEach>
                    </select>
                </div>
                <% }%>
            </div>

            <hr class="text-white">

        </div>
        <div class="text-center">
            <button class="btn btn-secondary col-md-3"  type="Submit">Cadastrar</button>
        </div>
        <br>
    </form>




    <!--===============================================================================================-->	
    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/bootstrap/js/popper.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="js/main.js" type="text/javascript" ></script>

</html>
