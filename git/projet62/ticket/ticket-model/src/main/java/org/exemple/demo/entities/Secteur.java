package org.exemple.demo.entities;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "SECTEUR")
public class Secteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    
    
    private int SecteurId;
    
    private String LibelleSecteur ;

    private int LongueurSecteur ;
    
    @OneToOne
    @JoinColumn(name = "cotation_id")
    private Cotation cotation;

    @Column(name= "SecteurId")
    public int getSecteurId() {
        return SecteurId;
    }

    public void setSecteurId(int id) {
        this.SecteurId = id;
    }
 
    @Column(name= "LibelleSecteur")
    public String getLibelleSecteur() {
        return LibelleSecteur;
    }

    public void setLibelleSecteur(String LibelleSecteur) {
        this.LibelleSecteur = LibelleSecteur;
    }

    @Column(name= "LongueurSecteur")
    public int getLongueurSecteur() {
        return LongueurSecteur;
    }

    public void setLongueurSecteur(int LongueurSecteur) {
        this.LongueurSecteur = LongueurSecteur;
    }
}
