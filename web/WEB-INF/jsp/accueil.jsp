<%-- 
    Document   : accueil
    Created on : 26-Apr-2020, 6:30:58 PM
    Author     : Tous les bg de ce monde
--%>
<%@page import="com.mhaddad.pfw.services.UtilisateurServices"%>
<%@page import="com.mhaddad.pfw.singleton.DbConnexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./resources/styles/bootstrap413/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="./resources/styles/style.css" rel="stylesheet" type="text/css" />

    </head>    
    <body>
         <div class="container">
        <jsp:include page="header.jsp"/>
        
        <h1 class="jumbotron">Accueil</h1>
        </div>
    </body>
</html>
