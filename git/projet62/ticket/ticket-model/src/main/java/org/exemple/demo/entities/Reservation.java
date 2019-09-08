package org.exemple.demo.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String Num_Topologie ;


    private String Auteur ;

    private String Date_Ajout ;

    public String getNum_Topologie() {
        return Num_Topologie;
    }

    public void setNum_Topologie(String num_cotation) {
        this.Num_Topologie = Num_Topologie;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }

    public String getDate_Ajout() {
        return Date_Ajout;
    }

    public void setDate_Ajout(String Date_Ajout) {
        this.Date_Ajout = Date_Ajout;
    }


}

