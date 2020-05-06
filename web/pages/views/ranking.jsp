<%-- 
    Document   : ranking
    Created on : 05/05/2020, 14:59:34
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
                            <td><a href="${context}/fifa?page=showRanking&id=${champ.id}"> 
                                    <i class="fas fa-eye text-white"></i></a>


                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>


        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>

    </body>
</html>
