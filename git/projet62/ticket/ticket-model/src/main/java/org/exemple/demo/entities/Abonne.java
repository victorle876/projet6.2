package org.exemple.demo.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ABONNE")
public class Abonne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length=45)
    private String nom_abonne ;
    public String getNom_abonne() {
        return nom_abonne;
    }

    public void setNom_abonne(String nom_abonne) {
        this.nom_abonne = nom_abonne;
    }

    @Column(length=45)
    private String prenom_abonne ;
    public String getPrenom_abonne() {
        return prenom_abonne;
    }

    public void setPrenom_abonne(String prenom_abonne) {
        this.prenom_abonne = prenom_abonne;
    }

    private String date_naissance ;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password ;

    private String role_abonne ;
    private String mail_abonne ;
    private String date_adhesion ;
    private String niveau_abonne ;


    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getRole_abonne() {
        return role_abonne;
    }

    public void setRole_abonne(String role_abonne) {
        this.role_abonne = role_abonne;
    }

    public String getMail_abonne() {
        return mail_abonne;
    }

    public void setMail_abonne(String mail_abonne) {
        this.mail_abonne = mail_abonne;
    }

    public String getDate_adhesion() {
        return date_adhesion;
    }

    public void setDate_adhesion(String date_adhesion) {
        this.date_adhesion = date_adhesion;
    }

    public String getNiveau_abonne() {
        return niveau_abonne;
    }

    public void setNiveau_abonne(String niveau_abonne) {
        this.niveau_abonne = niveau_abonne;
    }
}


