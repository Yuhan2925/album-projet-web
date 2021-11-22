<%-- 
    Document   : profil
    Created on : 2020-05-25, 18:13:48
    Author     : charl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
        <title>Profil</title>
    </head>
    <script>
           
</script>
    <body>
         <div class="container">
        <jsp:include page="header.jsp"/>
            <div class="container-fluid h-100">
                <div class="row justify-content-center align-items-center h-75">
                    <div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
                        <h1 class="text-center">${nom} ${prenom}</h1>
                            
                                            <a href="modificationProfil">modif</a>
                        <!--- Affichage de la photo-->
                        <div class="container">
                            <div class="d-flex justify-content-center h-100">
                                <div class="image_outer_container">
                                    <div class="green_icon"></div>
                                    <div class="image_inner_container">
                                       <img src="./resources/media/profil/${photoProfil}"> 
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                                       <c:forEach items="${publications}" var="unPub">
                                            <a href="p/"${unPub}>${unPub}</a>       
                                       </c:forEach>
                    </div>
                </div>
            </div>                          
        </div>
    </body>
</html>
