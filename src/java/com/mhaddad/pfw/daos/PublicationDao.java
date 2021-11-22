/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mhaddad.pfw.daos;

import com.mhaddad.pfw.entites.Profil;
import com.mhaddad.pfw.entites.Publication;
import com.mhaddad.pfw.singleton.DbConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mhaddad.pfw.entites.Publication.Type;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author charl
 */
public class PublicationDao extends SqlDAO<Publication>{

    @Override
    public boolean create(Publication x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Publication x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Publication x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Publication findById(int x) {
        Publication unePublication = null;
        
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement("SELECT * FROM publication WHERE id=?");
            stm.setInt(1, x);
            ResultSet res = stm.executeQuery();
            if(res.next()){
                // a changer
                unePublication = new Publication();
                unePublication.setId(x);
                unePublication.setPseudoUtilisateur(res.getString("utilisateur_pseudonyme"));
                unePublication.setDate();
                unePublication.setDescription(res.getString("description"));
                unePublication.setLike(res.getInt("like"));
                unePublication.setTitre(res.getString("titre"));
                unePublication.setType(Type.valueOf(res.getString("format")));
            }
        } catch (SQLException e) {
            Logger.getLogger(ProfilDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return unePublication;   
    }
    
    public List<Publication> trouverToutParPseudonyme(String x) {
        Publication unePublication = null;
        List<Publication> liste = null;
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement("SELECT * FROM publication WHERE utilisateur_pseudonyme=?");
            stm.setString(1, x);
            ResultSet res = stm.executeQuery();
            liste = new LinkedList();
            while(res.next()){
                // a changer
                unePublication = new Publication();
                unePublication.setId(res.getInt("id"));
                unePublication.setPseudoUtilisateur(x);
                unePublication.setDate();
                unePublication.setDescription(res.getString("description"));
                unePublication.setLike(res.getInt("like"));
                unePublication.setTitre(res.getString("titre"));
                unePublication.setType(Type.valueOf(res.getString("format")));
                liste.add(unePublication);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProfilDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return liste;   
    }

    @Override
    public Publication findById(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Publication> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*public static Publication getPublication(int unId){
        Publication laPublication = null;
        Connection cnx = DbConnexion.getConnexion();
        
        try{
            PreparedStatement stm = cnx.prepareStatement("SELECT * FROM publication WHERE id=?");
            stm.setInt(1, unId);
            ResultSet res = stm.executeQuery();
            if(res.next()){
                laPublication = new Publication((Type)res.getObject("format"), UtilisateurDao.getUtilisateurParPseudo(res.getString("utilisateur_pseudonyme")), res.getString("titre"), res.getString("description"), res.getDate("date"), res.getInt("like"));
            }
        }catch(SQLException e){
            Logger.getLogger(PublicationDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return laPublication;
        
    }*/
    
}
