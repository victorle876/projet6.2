package org.exemple.demo.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SECTEUR")
public class Secteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    
    @Column(name= "Secteur_Id")
    private int Secteur_Id;
    
    @OneToOne
    @JoinColumn(name = "Cotation_id")
    private Cotation cotation;

    public int getSecteur_Id() {
        return Secteur_Id;
    }

    public void setSecteur_Id(int id) {
        this.Secteur_Id = id;
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
