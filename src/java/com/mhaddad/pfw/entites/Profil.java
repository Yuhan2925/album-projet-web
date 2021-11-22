package com.mhaddad.pfw.entites;

/**
 *
 * @author Massy
 */

public class Profil {
    private String nom;
    private String prenom;
    private String photo;
    private int id;

    // Accesseur(s)
    public String getNom() { return this.nom; }
    public String getPrenom() { return this.prenom; }
    public String getUrlPhoto() {return this.photo;}
    public int getId(){return this.id;}
    // Mutateur(s) :
    public void setNom(String unNom){nom = unNom;}
    public void setPrenom(String unPrenom){prenom = unPrenom;}
    public void setUrlPhoto(String urlNouveau){this.photo = urlNouveau;}
    public void setId(int unId){this.id = unId;}
    // Autre(s) méthode(s)
    public String toString() {
        return this.nom + " "+ this.prenom + " // Photo de profil : "+this.photo;
    }
}
