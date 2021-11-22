/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mhaddad.pfw.services;

import com.mhaddad.pfw.daos.ProfilDao;
import com.mhaddad.pfw.daos.UtilisateurDao;
import com.mhaddad.pfw.entites.Profil;
import com.mhaddad.pfw.entites.Utilisateur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author charl
 */
public class UtilisateurServices{
    
    private UtilisateurDao dao;
    public void setDao(UtilisateurDao dao) {
        this.dao = dao;
    }
    
    public boolean modifierUtilisateur(Utilisateur nouveauUtilisateur, String unPseudo){
        return dao.modifierUtilisateurParPseudo(nouveauUtilisateur, unPseudo);
    }
    public Utilisateur getUtilisateurParPseudoMdp(String unPseudonyme, String unMotDePasse){
        Utilisateur unUtilisateur;
        unUtilisateur = dao.getUtilisteurParPseudoMdp(unPseudonyme, unMotDePasse);
        if(unUtilisateur == null){
            return null;
        }
        return dao.getUtilisteurParPseudoMdp(unPseudonyme, unMotDePasse);
    }
    public Utilisateur getUtilisateurParPseudo(String unPseudonyme){
        return dao.findById(unPseudonyme);
    }
    public Utilisateur getUtilisateurParIdProfil(int id){
        return dao.getUtilisateurParIdProfil(id);
    }
    public boolean validerPseudo(String unPseudo){
        if(dao.findById(unPseudo) == null){
            return true;
        }
        return false;
    }
    public boolean validerCourriel(String unCourriel){
        for (Utilisateur unUser : dao.findAll()){
            if (unUser.getCourriel().equals(unCourriel)){
                return false;
            }
        }
        return true;
    }
    public boolean inscrire(Utilisateur unUtilisateur){
        unUtilisateur.setDateCreation();
        return dao.create(unUtilisateur);
    }
    
    
    public List<Utilisateur> trouverTout(){
        return dao.findAll();
    }
}
