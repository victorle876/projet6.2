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

    private String Libelle_Secteur ;

    private int Longueur_Secteur ;

    public String getLibelle_Secteur() {
        return Libelle_Secteur;
    }

    public void setLibelle_Secteur(String Libelle_Secteur) {
        this.Libelle_Secteur = Libelle_Secteur;
    }

    public int getLongueur_Secteur() {
        return Longueur_Secteur;
    }

    public void setLongueur_Secteur(int Longueur_Secteur) {
        this.Longueur_Secteur = Longueur_Secteur;
    }
}
