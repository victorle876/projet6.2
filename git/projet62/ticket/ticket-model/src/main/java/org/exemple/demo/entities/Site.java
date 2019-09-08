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

    private String Libelle_Site ;
    private String Date_aAout ;
    private int nombre_secteur ;
    private int nombre_cotation ;

    private int longueur ;
    private int hauteur_mini ;
    private int hauteur_maxi ;


    public String getLibelle_Site() {
        return Libelle_Site;
    }

    public void setLibelle_Site(String Libelle_Site) {
        this.Libelle_Site = Libelle_Site;
    }

    public String getDate_aAout() {
        return Date_aAout;
    }

    public void setDate_aAout(String Date_aAout) {
        this.Date_aAout = Date_aAout;
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
