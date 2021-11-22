package com.mhaddad.pfw.entites;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Massy
 */

public class Publication {
    
    // enum
    public enum Type{
        PHOTO,
        VIDEO
    }
    
    
    // Attributs
    private String pseudoUtilisateur;
    private String titre;
    private LocalDate date;
    private int like;
    private String description;
    private Type type;
    private int id;
    // Accesseurs
    
    /**
     * Getter du type
     * @return le type
     */
    public Type getType(){
        return this.type;
    }
    /**
     * Getter de utilisateur
     * @return Utilisateur
     */
    public String getPseudoUtilisateur() { return this.pseudoUtilisateur; }
    
    /**
     * Getter de titre
     * @return String
     */
    public String getTitre() { return this.titre; }
    
     /**
     * Getter de id
     * @return int
     */
    public int getId() { return this.id; }
    /**
     * Getter de date
     * @return LocalDate
     */
    public LocalDate getDate() { return this.date; }
    
    /**
     * Getter de like
     * @return int
     */
    public int getLike() { return this.like; }
    
    /**
     * Getter de description
     * @return String
     */
    public String getDescription() { return this.description; }
   
    // Mutateurs

    /**
     * Setter pour le type
     * @param unType
     */
    public void setType(Type unType){
        this.type = unType;
    }
    /**
     * Setter de utilisateur
     * @param unUtilisateur
     */
    public void setPseudoUtilisateur(String unPseudo) {
        this.pseudoUtilisateur = unPseudo;
    }
    
    /**
     * Setter de titre
     * @param unTitre
     */
    public void setTitre(String unTitre) {
        this.titre = unTitre;
    }
    
    /**
     * Setter de date
     * @param uneDate
     */
    public void setDate() {
        this.date = LocalDate.now();
    }
    
    /**
     * Setter de like
     * @param unLike
     */
    public void setLike(int unLike) {
        this.like = unLike;
    }
    /**
     * Setter de id
     * @param unId
     */
    public void setId(int unId) {
        this.id = unId;
    }
    
    /**
     * Setter de description
     * @param uneDescription
     */
    public void setDescription(String uneDescription) {
        this.description = uneDescription;
    }
   
    // Autres fonctions
 
    public String toString(){
        return this.titre+" fait par : "+this.pseudoUtilisateur+"| Description : "+this.description+" | "+this.like+" Likes"+" publié le : "+this.date;
    }
}
