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
        this.Auteur = auteur;
    }


    private String Zone_Commentaire ;
    private String Etat ;

    private String Date_Maj ;


    public String getZone_Commentaire() {
        return Zone_Commentaire;
    }

    public void setZone_Commentaire(String Zone_Commentaire) {
        this.Zone_Commentaire = Zone_Commentaire;
    }


    public String getDate_Maj() {
        return Date_Maj;
    }

    public void setDate_Maj(String Date_Maj) {
        this.Date_Maj = Date_Maj;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        this.Etat = etat;
    }
}
