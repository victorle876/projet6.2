package org.exemple.demo.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SECTEUR")
public class Secteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String libelle_secteur ;

    private int longueur_secteur ;

    public String getLibelle_secteur() {
        return libelle_secteur;
    }

    public void setLibelle_secteur(String libelle_secteur) {
        this.libelle_secteur = libelle_secteur;
    }

    public int getLongueur_secteur() {
        return longueur_secteur;
    }

    public void setLongueur_secteur(int longueur_secteur) {
        this.longueur_secteur = longueur_secteur;
    }
}
