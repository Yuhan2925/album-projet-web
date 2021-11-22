<%-- 
    Document   : inscription
    Created on : 2020-05-26, 19:21:54
    Author     : charl
--%>

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
        <title>Page d'inscription</title>
    </head>
    <body>
        
        <form:form method="post" modelAttribute="Utilisateur">
           
            Pseudonyme : <br/>
            <form:input type="text" path="pseudonyme"/><br/>
            Mot de passe : <br/>
            <form:input type="password" path="motDePasse"/><br/>
            Courriel : <br/>
            <form:input type="text" path="courriel"/><br/>
            Numéro de téléphone : <br/>
            <form:input type="text" path="numTel"/><br/>
            
            <input type="submit" value="S'inscrire"/>
        </form:form>
            
        ${erreur}
    </body>
</html>
