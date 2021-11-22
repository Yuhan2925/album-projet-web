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
public class PublicationController {    
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
    
}
