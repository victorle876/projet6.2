package org.exemple.demo.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "SITE")
public class Site implements Serializable{
    /*  */

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String libelle_site ;
    private String date_ajout ;
    private int nombre_secteur ;
    private int nombre_cotation ;

    private int longueur ;
    private int hauteur_mini ;
    private int hauteur_maxi ;


    public String getLibelle_site() {
        return libelle_site;
    }

    public void setLibelle_site(String libelle_site) {
        this.libelle_site = libelle_site;
    }

    public String getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(String date_ajout) {
        this.date_ajout = date_ajout;
    }

    public int getNombre_secteur() {
        return nombre_secteur;
    }

    public void setNombre_secteur(int nombre_secteur) {
        this.nombre_secteur = nombre_secteur;
    }

    public int getNombre_cotation() {
        return nombre_cotation;
    }

    public void setNombre_cotation(int nombre_cotation) {
        this.nombre_cotation = nombre_cotation;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getHauteur_mini() {
        return hauteur_mini;
    }

    public void setHauteur_mini(int hauteur_mini) {
        this.hauteur_mini = hauteur_mini;
    }

    public int getHauteur_maxi() {
        return hauteur_maxi;
    }

    public void setHauteur_maxi(int hauteur_maxi) {
        this.hauteur_maxi = hauteur_maxi;
    }
}
