package org.exemple.demo.entities;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
@Entity
@Table(name = "SITE")
@NamedQueries({
    @NamedQuery(name = Site.Find_By_Secteur_Site, query = "SELECT Secteur_Id, site FROM Secteur s1 r WHERE s1.secteur = :secteur "),
    
})
public class Site implements Serializable{
	
	public static final String Find_By_Secteur_Site = "Site.FindBySecteur";

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
    
    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
    private Secteur secteur;

    private String Libelle_Site ;
    private Timestamp Date_Ajout ;
    private int Nombre_Secteur ;
    private int Nombre_Cotation ;

    private int Longueur ;
    private int Hauteur_Mini ;
    private int Hauteur_Maxi ;
    

	public String getLibelle_Site() {
        return Libelle_Site;
    }

    public void setLibelle_Site(String Libelle_Site) {
        this.Libelle_Site = Libelle_Site;
    }

    public Timestamp getDate_Ajout() {
        return Date_Ajout;
    }

    public void setDate_Ajout(Timestamp Date_Ajout) {
        this.Date_Ajout = Date_Ajout;
    }

    public int getNombre_Secteur() {
        return Nombre_Secteur;
    }

    public void setgetNombre_Secteur(int Nombre_Secteur) {
        this.Nombre_Secteur = Nombre_Secteur;
    }

    public int getNombre_Cotation() {
        return Nombre_Cotation;
    }

    public void setNombre_Cotation(int Nombre_Cotation) {
        this.Nombre_Cotation = Nombre_Cotation;
    }

    public int getLongueur() {
        return Longueur;
    }

    public void setLongueur(int longueur) {
        this.Longueur = longueur;
    }

    public int getHauteur_Mini() {
        return Hauteur_Mini;
    }

    public void setHauteur_mini(int Hauteur_Mini) {
        this.Hauteur_Mini = Hauteur_Mini;
    }

    public int getHauteur_Maxi() {
        return Hauteur_Maxi;
    }

    public void setHauteur_maxi(int Hauteur_Maxi) {
        this.Hauteur_Maxi = Hauteur_Maxi;
    }
}
