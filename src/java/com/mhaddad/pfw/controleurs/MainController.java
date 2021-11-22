/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mhaddad.pfw.controleurs;

import com.mhaddad.pfw.entites.Profil;
import com.mhaddad.pfw.entites.Utilisateur;
import com.mhaddad.pfw.services.ProfilServices;
import com.mhaddad.pfw.services.PublicationServices;
import com.mhaddad.pfw.services.UtilisateurServices;
import java.io.IOException;
import javafx.css.PseudoClass;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author charles
 */
@Controller
public class MainController {    
    private UtilisateurServices utilisateurServices;
    public void setUtilisateurServices(UtilisateurServices userServices) {
        this.utilisateurServices = userServices;
    }
    private ProfilServices profilServices;
    public void setProfilServices(ProfilServices profilServices) {
        this.profilServices = profilServices;
    }
    private PublicationServices publicationServices;
    public void setPublicationServices(PublicationServices publicationServices){
        this.publicationServices = publicationServices;
    }
    
    
    //@ResponseBody
    @RequestMapping("/")
    public String welcome(ModelMap model) {
        
        return "accueil";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public View creeConnectionAccueil(ModelMap model, @ModelAttribute("Utilisateur") Utilisateur login,HttpSession session) {
        
        if(session.getAttribute("utilisateur") == null){
            return new RedirectView("/connexion",true,false);
        }
            return new RedirectView("/"+login.getPseudonyme(),true,false);
    }
     @RequestMapping(value = "/",method = RequestMethod.POST)
    public View seConnecter(ModelMap model,@ModelAttribute("FormRecherche") FormRecherche formRecherche, HttpSession session) throws IOException
    {
        return new RedirectView("/profil"+formRecherche.getNom());
    }
    
    @RequestMapping(value = "/connexion",method = RequestMethod.POST)
    public View seConnecter(ModelMap model,@ModelAttribute("Utilisateur") Utilisateur login, HttpSession session) throws IOException
    {
        
        Utilisateur unUtilisateur = utilisateurServices.getUtilisateurParPseudoMdp(login.getPseudonyme(),login.getMotDePasse());
        if(unUtilisateur == null){
            login.setMotDePasse("");
            model.addAttribute("login", new Utilisateur());
            return new RedirectView("/",true,false);
        }else{
            session.setAttribute("utilisateur", unUtilisateur);
            session.setAttribute("pseudoConnecte",unUtilisateur.getPseudonyme());
            session.setAttribute("profil", profilServices.getProfilUtilisateur(unUtilisateur.getIdProfil()));
            model.put("profil", new Profil());
        }
        // vue qui permet d'afficher un profil
        return new RedirectView("/"+unUtilisateur.getPseudonyme(),true,false);
    }
    
    // CONNEXION
    @RequestMapping(value = "/connexion", method = RequestMethod.GET)
    public String profil(ModelMap model,HttpSession session,@ModelAttribute("Utilisateur") Utilisateur login) throws IOException
    {
        if(session.getAttribute("utilisateur") == null){
            session.invalidate();
            model.put("Utilisateur", new Utilisateur());
            return "connexion";
        }else{
           
        }
         return "accueil";
    }
    
    
    
    // INSCRIPTION
    @RequestMapping(value = "/inscription", method = RequestMethod.GET)
    public String btnInscription(ModelMap model) throws IOException
    {
        model.put("Utilisateur", new Utilisateur());
        return "inscription";
    }
    // post inscription
     @RequestMapping(value = "/inscription",method = RequestMethod.POST)
    public String sinscrire(ModelMap model,@ModelAttribute("Utilisateur") Utilisateur utilisateur, HttpSession session) throws IOException
    {
        
        if(!utilisateurServices.validerPseudo(utilisateur.getPseudonyme())){
            model.addAttribute("erreur", "Pseudonyme déjà utilisé! Veuillez en choisir un autre...");
            return "inscription";
        }else if(utilisateur.getMotDePasse().trim().equals("") || utilisateur.getMotDePasse().length() < 8){
            model.addAttribute("erreur","Mot de passe invalide!");
            return "inscription";
        }else if(!utilisateurServices.validerCourriel(utilisateur.getCourriel())){
            model.addAttribute("erreur", "Ce courriel est déjà utilisé!");
            return "inscription";
        }else{
            Profil unProfil = new Profil();
            utilisateur.setIdProfil(profilServices.creeProfil(unProfil).getId());
        }
        
        if(!utilisateurServices.inscrire(utilisateur)){
            return "inscription";
        }else{
            model.addAttribute("salut",utilisateur.getPseudonyme());
            model.put("modifUtilisateur", new Utilisateur());
        model.put("modifProfil", new Profil());
            session.setAttribute("profil", profilServices.getProfilUtilisateur(utilisateur.getIdProfil()));
            session.setAttribute("utilisateur", utilisateur);
            
        }
            return "modificationProfil";
    }
  
   
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String  affichageProfilConnecte(ModelMap model,@ModelAttribute("Utilisateur")Utilisateur unUtilisateur,@PathVariable("id") String id, HttpSession session) throws IOException
    {
        Utilisateur user = utilisateurServices.getUtilisateurParPseudoMdp(unUtilisateur.getPseudonyme(), unUtilisateur.getMotDePasse());
        if (session.getAttribute("utilisateurConnecte") == null){
            model.put("userConnecte",null);
        }
        
        if(utilisateurServices.getUtilisateurParPseudo(id) == null){
            return "pageErreur";
        }else{
             unUtilisateur=utilisateurServices.getUtilisateurParPseudo(id);
              Profil leProfil = profilServices.getProfilUtilisateur(unUtilisateur.getIdProfil());
             if(leProfil != null){
                model.put("nom", leProfil.getNom());
                model.put("prenom", leProfil.getPrenom());
                model.put("photoProfil", leProfil.getUrlPhoto());
                model.put("publications", publicationServices.trouverToutParPseudonyme(id));
                
            }else{
                 return "pageErreur";
             }
        }
        return "profil";
    }
    @RequestMapping("/modificationProfil")
    public String  modifierProfil(ModelMap model,HttpSession session) throws IOException
    {
        model.put("modifUtilisateur", new Utilisateur());
        model.put("modifProfil", new Profil());
        return "modificationProfil";
    }
    
    @RequestMapping(value = "/modificationProfil", method = RequestMethod.POST)
    public String  modifierProfilPost(ModelMap model,HttpSession session,@ModelAttribute("modifProfil") Profil unProfil,@ModelAttribute("modifUtilisateur") Utilisateur unUtilisateur) throws IOException
    {
        utilisateurServices.modifierUtilisateur(unUtilisateur, (String)session.getAttribute("utilisateurConnecte"));
        return "modificationProfil";
    }
    
    
      @RequestMapping("/deconnexion")
    public View  decoUser(ModelMap model, HttpSession session) throws IOException
    {
        session.invalidate();
        return new RedirectView("/", true, false);
    }
    @RequestMapping("/accueil")
    public View  voirAccuueil(ModelMap model) throws IOException
    {
        return new RedirectView("/connexion",true,false);
    }
     @RequestMapping("/inscription")
    public View  voirInscription(ModelMap model) throws IOException
    {
        return new RedirectView("/profil",true,false);
    }
    
    public static class FormRecherche{
        String nom;
        
        public String getNom(){
            return this.nom;
        }
        public void setNom(String nom){
            this.nom = nom;
        }
    }
}
