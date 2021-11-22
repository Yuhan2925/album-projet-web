<%-- 
    Document   : modificationProfil
    Created on : 2020-05-26, 19:25:56
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
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="./resources/styles/bootstrap413/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="./resources/styles/style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
            <div class="container">
               <jsp:include page="header.jsp"/>
            <div class="row flex-lg-nowrap">
              <div class="col-12 col-lg-auto mb-3" style="width: 200px;">
                <div class="card p-3">
                  <div class="e-navlist e-navlist--active-bg">
                    <ul class="nav">
                      <li class="nav-item"><a class="nav-link px-2" href="./users.html"><i class="fa fa-fw fa-th mr-1"></i><span>Publications</span></a></li>
                      <li class="nav-item"><a class="nav-link px-2" href="./settings.html"><i class="fa fa-fw fa-cog mr-1"></i><span>Modification</span></a></li>
                    </ul>
                  </div>
                </div>
              </div>

              <div class="col">
                <div class="row">
                  <div class="col mb-3">
                    <div class="card">
                      <div class="card-body">
                        <div class="e-profile">
                          <div class="row">
                            <div class="col-12 col-sm-auto mb-3">
                              <div class="mx-auto" style="width: 140px;">
                                <div class="d-flex justify-content-center align-items-center rounded" style="height: 140px; background-color: rgb(233, 236, 239);">
                                  <span style="color: rgb(166, 168, 170); font: bold 8pt Arial;">140x140</span>
                                </div>
                              </div>
                            </div>
                            <div class="col d-flex flex-column flex-sm-row justify-content-between mb-3">
                              <div class="text-center text-sm-left mb-2 mb-sm-0">
                                <h4 class="pt-sm-2 pb-1 mb-0 text-nowrap">${sessionScope.utilisateur.getPseudonyme()}</h4>
                                <p class="mb-0">${sessionScope.profil.getNom()} ${sessionScope.profil.getPrenom()}</p>
                                <div class="text-muted"><small>"Last seen 2 hours ago" (*optionel --> https://www.baeldung.com/spring-security-track-logged-in-users)</small></div>
                                <div class="mt-2">
                                  <button class="btn btn-primary" type="button">
                                    <i class="fa fa-fw fa-camera"></i>
                                    <span>Changer la photo</span>
                                  </button>
                                </div>
                              </div>
                              <div class="text-center text-sm-right">
                                
                                <div class="text-muted"><small>Depuis: ${sessionScope.utilisateur.getDateCreation()}</small></div>
                              </div>
                            </div>
                          </div>

                          <div class="tab-content pt-3">
                            <div class="tab-pane active">
                              <form:form method="post" modelAttribute="modifProfil" class="form"> <form class="form" novalidate="">
                                <div class="row">
                                  <div class="col">
                                    <div class="row">
                                      <div class="col">
                                        <div class="form-group">
                                          <label>Nom</label>
                                          <form:input type="text" path="nom" placeholder="Nom" class="form-control"/>
                                        </div>
                                      </div>
                                      <div class="col">
                                        <div class="form-group">
                                          <label>Prenom</label>
                                          <form:input type="text" path="prenom" placeholder="Prenom" class="form-control"/>
                                        </div>
                                      </div>
                                    </div
                                    </form:form>
                                    <form:form method="post" modelAttribute="modifUtilisateur">
                                    <div class="row">
                                      <div class="col">
                                        <div class="form-group">
                                          <label>Courriel</label>
                                          <form:input type="text" path="courriel" placeholder="courriel@example.com" class="form-control"/>
                                        </div>
                                      </div>
                                    </div>
                                    <!-- <div class="row">
                                      <div class="col mb-3">
                                        <div class="form-group">
                                          <label>Biographie</label>
                                          <textarea class="form-control" rows="5" placeholder="Ma bio"></textarea>
                                        </div>
                                      </div>
                                    </div> -->
                                  </div>
                                </div>
                                <div class="row">
                                  <div class="col-12 col-sm-6 mb-3">
                                    <div class="mb-2"><b>Changer le mot de passe</b></div>
                                    <div class="row">
                                      <div class="col">
                                        <div class="form-group">
                                          <label>Mot de passe actuel</label>
                                          <input type="password"  placeholder="••••••" class="form-control"/>
                                        </div>
                                      </div>
                                    </div>
                                    <div class="row">
                                      <div class="col">
                                        <div class="form-group">
                                          <label>Nouveau mot de passe</label>
                                          <form:input type="password" path="motDePasse" placeholder="••••••" class="form-control"/>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                                <div class="row">
                                  <div class="col d-flex justify-content-end">
                                    <input type="submit" value="Sauvegarder" class="btn btn-primary"/>                                    
                                  </div>
                                </div>
                              </form:form>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
        </div>  
    </body>
</html>
