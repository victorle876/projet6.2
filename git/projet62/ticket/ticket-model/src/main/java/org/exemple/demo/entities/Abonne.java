package org.exemple.demo.entities;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List.*;

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
@Table(name = "ABONNE")
public class Abonne implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name= "abonne_id")
	private int id;
	
    private String Nom_Abonne ;
	
    private String Prenom_Abonne ;
	
    private String Date_Naissance ;
	
    private String Password ;

    private String Role_Abonne ;
    private String Mail_Abonne ;
    private Timestamp Date_Adhésion ;
    private String Niveau_Abonne ;
    
    @OneToOne
    @JoinColumn(name = "Reservation_id")
    private Reservation reservation;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length=45)
    public String getNom_Abonne() {
        return Nom_Abonne;
    }

    public void setNom_Abonne(String Nom_Abonne) {
        this.Nom_Abonne = Nom_Abonne;
    }

    @Column(length=45)

    public String getPrenom_Abonne() {
        return Prenom_Abonne;
    }

    public void setPrenom_Abonne(String Prenom_Abonne) {
        this.Prenom_Abonne = Prenom_Abonne;
    }



    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getDate_Naissance() {
        return Date_Naissance;
    }

    public void setDate_Naissance(String Date_Naissance) {
        this.Date_Naissance = Date_Naissance;
    }

    public String getRole_Abonne() {
        return Role_Abonne;
    }

    public void setRole_Abonne(String Role_Abonne) {
        this.Role_Abonne = Role_Abonne;
    }

    public String getMail_Abonne() {
        return Mail_Abonne;
    }

    public void setMail_Abonne(String Mail_Abonne) {
        this.Mail_Abonne = Mail_Abonne;
    }

    public Timestamp getDate_Adhésion() {
        return Date_Adhésion;
    }

    public void setDate_Adhsésion(Timestamp Date_Adhésion) {
        this.Date_Adhésion = Date_Adhésion;
    }

    public String getNiveau_Abonne() {
        return Niveau_Abonne;
    }

    public void setNiveau_Abonne(String Niveau_Abonne) {
        this.Niveau_Abonne = Niveau_Abonne;
    }
}


