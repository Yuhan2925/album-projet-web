package com.mhaddad.pfw.entites;

import java.time.LocalDate; // import the LocalDate class
import java.util.ArrayList;

/**
 *
 * @author Massy
 */

public class Utilisateur {
    public enum Role{
        USAGER,
        ADMIN
    }
    // Attributs
    private String pseudonyme;
    private String motDePasse;
    private int idProfil;
    private String courriel; 
    private String numTel;
    private LocalDate dateCreation;
    private Role role;
    private ArrayList<Utilisateur> listeAmis;
    
    
    // Getters

    /**
     * Getter de l'attribut pseudonyme
     * @return String
     */
    public String getPseudonyme() { return this.pseudonyme; }
    
    /**
     * Getter de l'attribut role
     * @return Role
     */
    public Role getRole() { return this.role; }
    /**
     * Getter de l'attribut motDePasse
     * @return String
     */
    public String getMotDePasse() { return this.motDePasse; }
    
    /**
     * Getter de l'attribut profil
     * @return Profil
     */
    public int getIdProfil() { return this.idProfil; }
    
    /**
     * Getter de l'attribut courriel
     * @return String
     */
    public String getCourriel() { return this.courriel; }
    
    /**
     * Getter de l'attribut numTel
     * @return int
     */
    public String getNumTel() { return this.numTel; }
    
    /**
     * Getter de l'attribut dateCreation
     * @return LocalDate
     */
    public LocalDate getDateCreation() { return this.dateCreation; }
    
    // Setters

    /**
     * Setter de l'attribut pseudonyme
     * @param unPseudonyme
     */
    public void setPseudonyme(String unPseudonyme) {
        this.pseudonyme = unPseudonyme;
    }

    /**
     * Setter de l'attribut motDePasse
     * @param unMotDePasse
     */
    public void setMotDePasse(String unMotDePasse) {
        this.motDePasse = unMotDePasse;
    }

    /**
     * Setter de l'attribut profil
     * @param unProfil
     */
    public void setIdProfil(int unProfil) {
        this.idProfil = unProfil;
    }
    
    /**
     * Setter de l'attribut role
     * @param unRole
     */
    public void setRole(Role unRole) {
        this.role = unRole;
    }
    
    /**
     * Setter de l'attribut courriel
     * @param unCourriel
     */
    public void setCourriel(String unCourriel) {
        this.courriel = unCourriel;
    }
        
    /**
     * Setter de l'attribut numTel
     * @param unNumTel
     */
    public void setNumTel(String unNumTel ) {
        this.numTel = unNumTel;
    }
    
    /**
     * Setter de l'attribut dateCreation
     * @param uneDateCreation
     */
    public void setDateCreation() {
        this.dateCreation = LocalDate.now();
    }

    // Autres fonctions
    
    public String toString(){
        return pseudonyme+" : "+courriel;
    }
    
}
