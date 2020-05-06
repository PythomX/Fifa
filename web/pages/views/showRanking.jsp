<%-- 
    Document   : showRanking
    Created on : 05/05/2020, 15:01:12
    Author     : mateu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <div class="modal-body ">

            <div class="container w-25 opacity-tab border rounded p-1 mb-2 text-center text-white">
                <div class="col m-2 text-center">
                    <h2>Artilheiro</h2>
                    <i class="fas fa-crown m-1 fa-2x text-warning"></i>
                    <h3>${topScorer.nome}</h3>
                    <h4>${topScorer.timeNome}</h4>
                </div>
            </div>

            <table class="table table-striped p-1 table-bordered table-dark" border="1" cellspacing="1">
                <thead>
                    <tr>
                        <th title="Colocação" scope="col">Colocação</th>
                        <th title="Times" scope="col">Times</th>
                        <th title="Pontos" scope="col">PTS</th>
                        <th title="Vitórias" scope="col">V</th>
                        <th title="Derrotas" scope="col">D</th>
                        <th title="Empates" scope="col">E</th>
                        <th title="Partidas" scope="col">P</th>
                        <th title="Gols" scope="col">G</th>
                        <th title="Gols Tomados" scope="col">GT</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ranks}" var="rank" varStatus="status">
                        <tr>
                            <td>${status.count}º</td>
                            <td>${rank.idTime.nome}</td>
                            <td>${rank.pontos}</td>
                            <td>${rank.vitorias}</td>
                            <td>${rank.derrotas}</td>
                            <td>${rank.empates}</td>
                            <td>${rank.partidas}</td>
                            <td>${rank.gols}</td>
                            <td>${rank.golsTomado}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>



        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    </body>
</html>
