<%-- 
    Document   : jogadores
    Created on : 25/04/2020, 18:11:33
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
            <input type="hidden" name="page" value=""/>
            <div class="modal-body ">
                <table id="tableUser" class="table table-striped table-bordered table-dark text-center">
                    <thead class="thead-white">
                        <tr>
                            <th scope="col">#Id</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Login</th>
                            <th scope="col">Nivel de Acesso</th>
                        </tr>
                    </thead>
                    <c:forEach items="${users}" var="user" >

                        <tbody>
                            <tr>
                                <th scope="row">${user.getId()}</th>
                                <td>${user.getNome()}</td>
                                <td>${user.getLogin()}</td>
                                <c:if test="${user.getNivelAcesso()}">
                                    <td>Administrador</td>
                                </c:if>
                                <c:if test="${user.getNivelAcesso() != true}">
                                    <td>Player</td>
                                </c:if>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </form>



        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <script src="js/main.js" type="text/javascript" ></script>



    </body>
</html>
