package org.exemple.demo.entities;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
@Entity
@Table(name = "SITE")
@NamedQueries({
    @NamedQuery(name = Site.Find_By_Secteur_Site, query = "SELECT Secteur_Id, site FROM Secteur s1 r WHERE s1.secteur = :secteur "),
    
})
public class Site implements Serializable{
	
	public static final String Find_By_Secteur_Site = "Site.FindBySecteur";
	
    private String LibelleSite ;
    private Timestamp DateAjout ;
    private int NombreSecteur ;
    private int NombreCotation ;

    private int Longueur ;
    private int HauteurMini ;
    private int HauteurMaxi ;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name= "Site_Id")
    private int Site_Id;

    public int getSite_Id() {
        return Site_Id;
    }

    public void setSite_Id(int id) {
        this.Site_Id = id;
    }
    
    @OneToMany(mappedBy = "site")
    private Secteur secteur;

	public String getLibelleSite() {
        return LibelleSite;
    }

    public void setLibelleSite(String LibelleSite) {
        this.LibelleSite = LibelleSite;
    }

    @Column(name= "DateAjout")
    public Timestamp getDateAjout() {
        return DateAjout;
    }

    public void setDateAjout(Timestamp DateAjout) {
        this.DateAjout = DateAjout;
    }
    
    @Column(name= "NombreSecteur")
    public int getNombreSecteur() {
        return NombreSecteur;
    }

    public void setgetNombreSecteur(int NombreSecteur) {
        this.NombreSecteur = NombreSecteur;
    }
    
    @Column(name= "NombreCotation")
    public int getNombreCotation() {
        return NombreCotation;
    }

    public void setNombreCotation(int NombreCotation) {
        this.NombreCotation = NombreCotation;
    }
    
    @Column(name= "Longueur")
    public int getLongueur() {
        return Longueur;
    }

    public void setLongueur(int longueur) {
        this.Longueur = longueur;
    }
    
    @Column(name= "HauteurMini")
    public int getHauteurMini() {
        return HauteurMini;
    }

    public void setHauteurMini(int HauteurMini) {
        this.HauteurMini = HauteurMini;
    }
    
    @Column(name= "HauteurMaxi")
    public int getHauteurMaxi() {
        return HauteurMaxi;
    }

    public void setHauteurMaxi(int HauteurMaxi) {
        this.HauteurMaxi = HauteurMaxi;
    }
}
