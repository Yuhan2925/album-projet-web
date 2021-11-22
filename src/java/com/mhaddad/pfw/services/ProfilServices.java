/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mhaddad.pfw.services;

import com.mhaddad.pfw.daos.ProfilDao;
import com.mhaddad.pfw.entites.Profil;
/**
 *
 * @author charl
 */
public class ProfilServices {
   private ProfilDao profilDao;

    public void setDao(ProfilDao dao) {
        this.profilDao = dao;
    }
   public Profil getProfilUtilisateur(int id){
       
       return profilDao.findById(id);
   }
   public Profil creeProfil(Profil unProfil){
       return profilDao.creeProfil(unProfil);
   }
   public boolean modifierProfilParId(int idProfil, Profil newProfil ){
       return profilDao.modifierProfil(idProfil, newProfil);
   }
}
