<%-- 
    Document   : championship
    Created on : 29/04/2020, 12:21:17
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
        
        
        
        <table class="table table-bordered" border="1" cellspacing="1">
            <thead>
                <tr>
                    <th scope="col">#Id</th>
                    <th scope="col">Times</th>
                    <th scope="col">Data</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${champs}" var="champ">
                <tr>
                    <td>${champ.id}</td>
                    <td>${champ.idTime}</td>
                    <td>${champ.data}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        
        
        
        
    </body>
</html>
