
/**
 *
 * @author charlo Poitras
 * */
package com.mhaddad.pfw.daos;

import com.mhaddad.pfw.entites.Profil;
import com.mhaddad.pfw.entites.Utilisateur;
import com.mhaddad.pfw.services.ProfilServices;
import com.mhaddad.pfw.singleton.DbConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UtilisateurDao extends SqlDAO<Utilisateur>{
    ProfilServices profilServices = new ProfilServices();
    

   
    /**
     * Méthode qui ramene tous les amis de l'utilisateur
     * @param unPseudonyme
     * @return La liste des amis de l'utilisateur associé avec le pseudo
     */
    /**public static List<Utilisateur> getAmis(String unPseudonyme) {
        List<Utilisateur> liste;
        liste = new ArrayList();
        Connection cnx = DbConnexion.getConnexion();
        try {
            
            PreparedStatement stm = cnx.prepareStatement("SELECT u.pseudoUtilisateur from utilisateur u INNER JOIN amis f ON f.pseudoAmi = u.pseudoUtilisateur WHERE f.pseudoUtilisateur = ?");
            stm.setString(1, unPseudonyme);
            ResultSet res = stm.executeQuery();
            while (res.next()) {
                String unPseudo = res.getString("pseudoUtilisateur");
                liste.add(UtilisateurDao.getUtilisateurParPseudo(unPseudo));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
*/
    @Override
    public boolean create(Utilisateur x) {
        try{
            PreparedStatement stm = connexion.getInstance().prepareStatement("INSERT INTO utilisateur (pseudonyme, motDePasse, courriel, numeroTel, dateCreation,profil_id) VALUES (?,?,?,?,?,?)");
            stm.setString(1, x.getPseudonyme());
            stm.setString(2, x.getMotDePasse());
            stm.setString(3, x.getCourriel());
            stm.setString(4, x.getNumTel());
            stm.setDate(5, Date.valueOf(x.getDateCreation()));
            stm.setInt(6, x.getIdProfil());
            if (stm.executeUpdate() == 1){
                return true;
            }
            
        }catch(SQLException e){
           Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, e); 
        }
        return false;
    }

    @Override
    public boolean delete(Utilisateur x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean modifierUtilisateurParPseudo(Utilisateur nouveauUser, String unPseudo){
        // variable qui permet d'identifier si l'opération à fonctionné ou non
        boolean valider = false;
        // prendre le profil
        try {
           PreparedStatement stm = connexion.getInstance().prepareStatement("UPDATE utilisateur SET courriel=?, motDePasse=? WHERE pseudonyme=?");
            
            stm.setString(1, nouveauUser.getCourriel());
            stm.setString(2, nouveauUser.getMotDePasse());
            stm.setString(3, unPseudo);
            if(stm.executeUpdate()==1){
                valider=true;
            }
        } catch (SQLException e) {
            Logger.getLogger(ProfilDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return valider;
    }

    @Override
    public Utilisateur findById(String x) {
        Utilisateur unUtilisateur = null;
        Profil unProfil = null;
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement("SELECT * FROM utilisateur WHERE pseudonyme=?");
            stm.setString(1, x);
            ResultSet res = stm.executeQuery();
            if(res.next()){
                // a changer
                unUtilisateur = new Utilisateur();
                unUtilisateur.setPseudonyme(res.getString("pseudonyme"));
                unUtilisateur.setMotDePasse(res.getString("motDePasse"));
                unUtilisateur.setCourriel(res.getString("courriel"));
                unUtilisateur.setDateCreation();
                unUtilisateur.setNumTel("numeroTel");
                
                unUtilisateur.setIdProfil( res.getInt("profil_id"));

            }
        } catch (SQLException e) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return unUtilisateur;
    }

    @Override
    public Utilisateur findById(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> liste = null;
        Utilisateur unUtilisateur=null;
        try {
            liste = new ArrayList<Utilisateur>();
            PreparedStatement stm = connexion.getInstance().prepareStatement("SELECT * FROM utilisateur");
            ResultSet res = stm.executeQuery();
            while(res.next()){
                unUtilisateur = new Utilisateur();
                unUtilisateur.setPseudonyme(res.getString("pseudonyme"));
                unUtilisateur.setMotDePasse(res.getString("motDePasse"));
                unUtilisateur.setCourriel(res.getString("courriel"));
                unUtilisateur.setDateCreation();
                unUtilisateur.setNumTel(res.getString("numeroTel"));
                unUtilisateur.setIdProfil(res.getInt("profil_id"));
                liste.add(unUtilisateur);
            }
        } catch (SQLException e) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return liste;
    }
    /**
    * Méthode donnant la liste des amis d'un utilisateur
    * @param unPseudonyme Le String du pseudonyme d'un utilisateur
    * @param unMdp le mdp de l'utilisateur
    * @return L'utilisateur associé au mot de passe et pseudo
    */
    public Utilisateur getUtilisteurParPseudoMdp(String unPseudonyme, String unMdp){
       Utilisateur unUtilisateur=null;
       Profil unProfil =null;
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement("SELECT * FROM utilisateur WHERE pseudonyme=? AND motDePasse=?");
            stm.setString(1, unPseudonyme);
            stm.setString(2, unMdp);
            ResultSet res = stm.executeQuery();
            if(res.next()){
                unUtilisateur = new Utilisateur();
                unUtilisateur.setPseudonyme(res.getString("pseudonyme"));
                unUtilisateur.setMotDePasse(res.getString("motDePasse"));
                unUtilisateur.setCourriel(res.getString("courriel"));
                unUtilisateur.setDateCreation();
                unUtilisateur.setNumTel("numeroTel");
                unUtilisateur.setIdProfil(res.getInt("profil_id"));
            }
        
        
        } catch (SQLException e) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return unUtilisateur;
    }
    public Utilisateur getUtilisateurParIdProfil(int id){
       Utilisateur unUtilisateur=null;
        
        try {
            PreparedStatement stm = connexion.getInstance().prepareStatement("SELECT * FROM utilisateur WHERE profil_id=?");
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();
            if(res.next()){
                unUtilisateur = new Utilisateur();
                unUtilisateur.setPseudonyme(res.getString("pseudonyme"));
                unUtilisateur.setMotDePasse(res.getString("motDePasse"));
                unUtilisateur.setCourriel(res.getString("courriel"));
                unUtilisateur.setDateCreation();
                unUtilisateur.setIdProfil(res.getInt("profil_id"));
                unUtilisateur.setNumTel("numeroTel");
            }
        
        
        } catch (SQLException e) {
            Logger.getLogger(UtilisateurDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return unUtilisateur;
    }

    @Override
    public boolean update(Utilisateur x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

