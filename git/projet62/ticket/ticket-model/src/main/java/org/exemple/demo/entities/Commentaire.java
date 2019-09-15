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
    
    @Column(name= "commentaire_id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String Auteur ;
    
    private Timestamp DateMaj ;
    
    @OneToOne
    @JoinColumn(name = "Site_Id")
    private Site site;
    
    private String ZoneCommentaire ;
    private String Etat ;
    
    @OneToOne
    @JoinColumn(name = "Abonne_Id")
    private Abonne abonne;
    
    @Column(name= "Auteur")
    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        this.Auteur = auteur;
    }

    @Column(name= "ZoneCommentaire")
    public String getZoneCommentaire() {
        return ZoneCommentaire;
    }

    public void setZoneCommentaire(String ZoneCommentaire) {
        this.ZoneCommentaire = ZoneCommentaire;
    }

    @Column(name= "DateMaj")
    public Timestamp getDateMaj() {
        return DateMaj;
    }

    public void setDateMaj(Timestamp DateMaj) {
        this.DateMaj = DateMaj;
    }

    @Column(name= "Etat")
    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        this.Etat = etat;
    }
}
