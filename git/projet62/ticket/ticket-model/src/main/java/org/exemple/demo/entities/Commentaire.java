package org.exemple.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "COMMENTAIRE")
@NamedQueries({
    @NamedQuery(name = Commentaire.Find_By_Site_User, query = "SELECT commentaire, site , abonne FROM Commentaire c WHERE c.site = :site "),
})
public class Commentaire implements Serializable{
	
	public static final String Find_By_Site_User = "Commentaire.findBySiteAndAbonne";

 //   @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    
    @Column(name= "commentaire_id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String Auteur ;
    
    @OneToOne
    @JoinColumn(name = "Site_Id")
    private Site site;
    
    @OneToOne
    @JoinColumn(name = "Abonne_Id")
    private Abonne abonne;
    

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        this.Auteur = auteur;
    }


    private String Zone_Commentaire ;
    private String Etat ;

    private Timestamp Date_Maj ;


    public String getZone_Commentaire() {
        return Zone_Commentaire;
    }

    public void setZone_Commentaire(String Zone_Commentaire) {
        this.Zone_Commentaire = Zone_Commentaire;
    }


    public Timestamp getDate_Maj() {
        return Date_Maj;
    }

    public void setDate_Maj(Timestamp Date_Maj) {
        this.Date_Maj = Date_Maj;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        this.Etat = etat;
    }
}
