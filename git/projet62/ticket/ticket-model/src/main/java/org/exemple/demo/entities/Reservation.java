package org.exemple.demo.entities;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "RESERVATION")
//@NamedQueries({
//    @NamedQuery(name = Reservation.Find_By_Reservation_Topologie, query = "SELECT Reservation_Id, abonne , topologie FROM Reservation r WHERE r.topologie = :topologie "),
    
//})
public class Reservation implements Serializable {
	
//	public static final String Find_By_Reservation_Topologie = "Reservation.FindByReservationAndTopologie";

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    
    @Column(name= "Reservation_Id")
    private int id;
    
    private String Auteur ;

    private Timestamp DateAjout ;
    
    @OneToOne
    @JoinColumn(name = "Topologie_id")
    private Topologie topologie;
    
    @OneToOne
    @JoinColumn(name = "Abonne_id")
    private Abonne abonne;
    
	public Reservation(int id, String Auteur, Topologie topologie,
			Abonne abonne, Timestamp DateAjout) {
		this.id = id;
		this.Auteur = Auteur;
		this.abonne = abonne;
		this.topologie = topologie;
		this.DateAjout = DateAjout;
	 }

    public int getId() {
        return id;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }
    
    public Abonne getAbonne() {
        return abonne;
    }
    
    public void setTopologie(Topologie topologie) {
        this.topologie = topologie;
    }
    
    public Topologie getTopologie() {
        return topologie;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name= "Auteur")
    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }

    @Column(name= "DateAjout")
    public Timestamp getDateAjout() {
        return DateAjout;
    }

    public void setDateAjout(Timestamp DateAjout) {
        this.DateAjout = DateAjout;
    }


}

