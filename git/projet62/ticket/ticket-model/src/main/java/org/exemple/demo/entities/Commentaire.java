package org.exemple.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTAIRE")
public class Commentaire implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String Auteur ;


    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }


    private String zone_commentaire ;
    private String Etat ;

    private String date_maj ;


    public String getZone_commentaire() {
        return zone_commentaire;
    }

    public void setZone_commentaire(String zone_commentaire) {
        this.zone_commentaire = zone_commentaire;
    }


    public String getDate_maj() {
        return date_maj;
    }

    public void setDate_maj(String date_maj) {
        this.date_maj = date_maj;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }
}
