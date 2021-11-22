<%-- 
    Document   : connexion
    Created on : 2020-05-26, 19:15:22
    Author     : charl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./resources/styles/bootstrap413/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="./resources/styles/style.css" rel="stylesheet" type="text/css" />

        <title>Page de connexion</title>
    </head>
    <body>
        <div class="container">
            <div class="container-fluid h-100">
                <div class="row justify-content-center align-items-center h-75">
                    <div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
                        <h1 class="text-center">Se connecter</h1>
                        <br/>
                        <form:form method="post" modelAttribute="Utilisateur" class="justify-content-center">

                            <div class="form-group">
                              <label>Pseudonyme</label>
                              <form:input type="text" path="pseudonyme" placeholder="Pseudo" class="form-control"/><br/>
                            </div>

                            <div class="form-group">
                              <label>Mot de passe</label>
                              <form:input type="password" path="motDePasse" placeholder="Mot de passe" class="form-control"/>
                            </div>

                            <input type="submit" value="connexion" class="form-control-range"/>
                        </form:form>
                            <a href="inscription">S'inscrire?</a>
                            
                                ${erreur}
                            

                        
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
