<%-- 
    Document   : championship
    Created on : 29/04/2020, 12:21:17
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
            <c:if test="${user.nivelAcesso}">
                <a class="btn btn-dark offset-lg-10 text-white" type="button" href="${context}/fifa?page=showChamp">Novo<i class="fas fa-plus p-1 text-white"></i></a>
                <hr class="text-white">
            </c:if>
            <table id="tableUser" class="table table-striped table-bordered table-dark" border="1" cellspacing="1">
                <thead>
                    <tr>
                        <th scope="col">#Id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Times</th>
                        <th scope="col">Data</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${champs}" var="champ" varStatus="status">
                        <tr>
                            <td>${champ.id}</td>
                            <td>${champ.nome}</td>
                            <td>${quantidades[status.index].times}</td>
                            <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${champ.data}" /></td>

                            <c:if test="${user.nivelAcesso && champ.partidaList.size() <= 0}">
                                <td><a title="Iniciar" href="${context}/fifa?page=playChamp&id=${champ.id}">
                                        <i class="fas fa-play text-success"></i></a></td>
                                    </c:if>

                            <c:if test="${user.nivelAcesso && champ.partidaList.size() > 0}">
                                <td><a title="Editar" href="${context}/fifa?page=editChamp&id=${champ.id}"> 
                                        <i class="fas fa-edit text-white"></i></a></td>
                                    </c:if>

                            <c:if test="${!user.nivelAcesso}">
                                <td><a title="Visualizar" href="${context}/fifa?page=editChamp&id=${champ.id}"> 
                                        <i class="fas fa-eye text-white"></i></a></td>
                                    </c:if>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>


        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    </body>
</html>
