<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="./accueil">Fake-a-gram</a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="./accueil">Accueil<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="${sessionScope.utilisateur.getPseudonyme()}">Profil</a>
      </li> 
        
    </ul>
    <form class="form-inline my-2 my-lg-0" action="./" method="get">
        <input type="text" class="form-control mr-sm-2" placeholder="Rechercher.." name="pseudonyme">
        <button type="submit" class ="btn btn-outline-success my-2 my-sm-0"><i class="fa fa-search">Recherche</i></button>
    </form>
        
  </div>
</nav>
