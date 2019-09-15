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
@NamedQueries({
    @NamedQuery(name = Reservation.Find_By_Reservation_Topologie, query = "SELECT Reservation_Id, abonne , topologie FROM Reservation r WHERE r.topologie = :topologie "),
    
})
public class Reservation implements Serializable {
	
	public static final String Find_By_Reservation_Topologie = "Reservation.FindByReservationAndTopologie";

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

    public int getId() {
        return id;
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
    public Timestamp getDateAjou() {
        return DateAjout;
    }

    public void setDateAjoutjout(Timestamp DateAjout) {
        this.DateAjout = DateAjout;
    }


}

