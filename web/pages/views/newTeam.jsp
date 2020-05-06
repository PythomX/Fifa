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

    <c:if test="${requestScope.erro != null}">
        <div class="alert alert-danger text-center ">
            <strong> ${requestScope.erro}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <form action="${context}/fifa" method="POST">
        <input type="hidden" name="page" value="saveNewTeam"/>
        <div class="container">
        <div class="modal-body ">

            <div class="row justify-content-center">
                <input class="form-control col-md-8 m-4 mb-3 input-nome-time text-center" value="${user.idTime.nome}" readonly="true" type="text">
            </div>

                <% for (int i = 0; i < 11; i++) { %>
                <div class="m-2 text-center">
                    <input class="input-nome text-center" placeholder="Nome" required="" type="text" name="nomeJogador[]" id="input-name">
                    <select class="col-md-2 text-center input-nome" required="" id="inputState" name="posicaoJogador[]" >
                        <option selected disabled hidden>Posição</option>
                        <c:forEach items="${posicoes}" var="posicao">
                            <option value="${posicao.getPosicao()}">${posicao.getPosicao()}</option>
                        </c:forEach>
                    </select>
                </div>
                <% }%>

            <hr class="text-white">

        </div>
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
