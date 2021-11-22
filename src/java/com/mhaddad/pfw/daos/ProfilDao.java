/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mhaddad.pfw.daos;

import com.mhaddad.pfw.entites.Profil;
import com.mhaddad.pfw.entites.Utilisateur;
import com.mhaddad.pfw.singleton.DbConnexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charl
 */
public class ProfilDao extends SqlDAO<Profil>{
   
    
    /**
     * Ajout d'une photo de profil dans la db
     * @param unId le id du profil a changer
     * @param nouveauProfil les données du profil a changer
     * @return le boolean de la validation de l'ajout d'une photo
     */
    public boolean modifierProfil(int unId, Profil nouveauProfil){
        // variable qui permet d'identifier si l'opération à fonctionné ou non
        boolean valider = false;
        // prendre le profil
        try {
           PreparedStatement stm = connexion.getInstance().prepareStatement("UPDATE profil SET nom='?', prenom='?', photo_url='?' WHERE id='?'");
            
            stm.setString(1, nouveauProfil.getNom());
            stm.setString(2, nouveauProfil.getPrenom());
            stm.setString(3, nouveauProfil.getUrlPhoto());
            stm.setInt(4, unId);
            ResultSet res = stm.executeQuery();
            if(res.next()){
                valider=true;
            }
        } catch (SQLException e) {
            Logger.getLogger(ProfilDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return valider;
    }
    

    public Profil creeProfil(Profil x) {
        Profil unProfil=null;
        try {
            
         PreparedStatement stm = connexion.getInstance().prepareStatement("INSERT INTO profil (nom,prenom,photo_url) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        
            stm.setString(1, x.getNom());
            stm.setString(2, x.getPrenom());
            stm.setString(3, x.getUrlPhoto());
            if(stm.executeUpdate()==0){
                return unProfil;
            }
            try (ResultSet generatedKeys = stm.getGeneratedKeys()){
                if (generatedKeys.next()) {
                    
                    x.setId(generatedKeys.getInt(1));
                    System.out.println(x.getId());
                    return x;
            }
            } catch (Exception e) {
            }
        } catch (SQLException e) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, e); 
        }
        return unProfil;
    }

    @Override
    public boolean delete(Profil x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Profil x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profil findById(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profil findById(int x) {
        Profil unProfil = null;
        
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement("SELECT * FROM profil WHERE id=?");
            stm.setInt(1, x);
            ResultSet res = stm.executeQuery();
            if(res.next()){
                // a changer
                unProfil = new Profil();
                unProfil.setPrenom(res.getString("prenom"));
                unProfil.setNom(res.getString("nom"));
                unProfil.setUrlPhoto(res.getString("photo_url"));
                unProfil.setId(x);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProfilDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return unProfil;
    }

    @Override
    public List<Profil> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Profil x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
