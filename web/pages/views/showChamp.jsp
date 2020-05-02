<%-- 
    Document   : newChamp
    Created on : 29/04/2020, 17:04:05
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

        <br>
        <div class="form-group ">
            <input class="form-control col-md-4 text-center offset-4" form="champ" placeholder="Nome do Campeonato" required="" name="nomeChamp">
        </div>
        
        <div class="modal-body text-center ">
            <div class="row justify-content-center ">
                <div class="col-md-5">

                    <table id="tableUser" class="table table-bordered table-dark table-hover" border="0" cellspacing="1">
                        <thead>
                            <tr>
                                <th ></th>
                                <th>#Id</th>
                                <th>Nome</th>
                                <th>Login</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr >
                                    <td ><input type="checkbox" name="select1" /></td>
                                    <td><input type="hidden" name="id[]" value="${user.id}">${user.id}</td>
                                    <td>${user.nome}</td>
                                    <td>${user.login}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>


                <div class="row align-content-center">
                    <div class="col-md-5">
                        <button onclick="userToChamp()" class="btn btn-dark text-center "> >> </button>
                    </div>

                    <div class="col-md-5">
                        <button onclick="champToUser()" class="btn btn-dark text-center"> << </button>
                    </div>

                </div>

                <form action="${context}/fifa" method="POST" id="champ" class="col-md-5">
                    <input type="hidden" name="page" value="newChamp">

                    <table id="tableChamp" class="table table-bordered table-dark table-hover" border="0" cellspacing="1">
                        <thead>
                            <tr>
                                <th></th>
                                <th>#Id</th>
                                <th>Nome</th>
                                <th>Login</th>
                            </tr>
                        </thead>
                    </table>
                </form>

            </div>

            <div class="modal-footer justify-content-center">
                <button type="submit" form="champ" class="btn btn-dark col-md-3">Criar</button>
            </div>
        </div>







        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>

    </body>
</html>
