package org.exemple.demo.entities;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "SECTEUR")
public class Secteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    private String LibelleSecteur ;

    private int LongueurSecteur ;
    
    @OneToOne
    @JoinColumn(name = "cotation_id")
    private Cotation cotation;
    
	public Secteur(int id, String LibelleSecteur, Cotation cotation, int LongueurSecteur) {
		this.id = id;
		this.LibelleSecteur = LibelleSecteur;
		this.LongueurSecteur = LongueurSecteur;
		this.cotation = cotation;

}

    @Column(name= "SecteurId")
    public int getSecteurId() {
        return id;
    }

    public void setSecteurId(int id) {
        this.id = id;
    }
    
    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
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
