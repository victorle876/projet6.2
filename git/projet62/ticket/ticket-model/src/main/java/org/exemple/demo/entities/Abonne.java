package org.exemple.demo.entities;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List.*;

import javax.persistence.*;

@Entity
@Table(name = "ABONNE")
public class Abonne implements Serializable {
	 
	
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
    private String NomAbonne ;
	
    private String PrenomAbonne ;
	
    private Timestamp DateNaissance ;
	
    private String Password ;

    private String RoleAbonne ;
    private String MailAbonne ;
    
    private Timestamp DateAdhesion ;
    private String NiveauAbonne ;
    
  //  @ManyToOne(fetch = FetchType.LAZY)
  //  @JoinColumn(name = "Reservation_id")
    
    @OneToMany(mappedBy = "order")
    private Reservation reservation;
    
    public Abonne(int id, String NomAbonne, String PrenomAbonne, String Password,
    						String MailAbonne, String RoleAbonne, String NiveauAbonne, 
    						Timestamp DateAdhesion,Timestamp DateNaissance) {
        this.id = id;
        this.NomAbonne = NomAbonne;
        this.PrenomAbonne = PrenomAbonne;
        this.Password = Password;
        this.MailAbonne = MailAbonne;
        this.NiveauAbonne = NiveauAbonne;
        this.RoleAbonne = RoleAbonne;
        this.DateAdhesion = DateAdhesion;
        this.DateNaissance = DateNaissance;
      }

    @Column(name= "abonne_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name= "NomAbonne")
    public String getNomAbonne() {
        return NomAbonne;
    }

    public void setNomAbonne(String NomAbonne) {
        this.NomAbonne = NomAbonne;
    }

    @Column(name= "PrenomAbonne")
    public String getPrenomAbonne() {
        return PrenomAbonne;
    }

    public void setPrenomAbonne(String PrenomAbonne) {
        this.PrenomAbonne = PrenomAbonne;
    }
    
    @Column(name= "Password")
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    @Column(name= "DateNaissance")
    public Timestamp getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(Timestamp DateNaissance) {
        this.DateNaissance = DateNaissance;
    }
    
    @Column(name= "RoleAbonne")
    public String getRoleAbonne() {
        return RoleAbonne;
    }

    public void setRoleAbonne(String RoleAbonne) {
        this.RoleAbonne = RoleAbonne;
    }
    
    @Column(name= "MailAbonne")
    public String getMailAbonne() {
        return MailAbonne;
    }

    public void setMailAbonne(String MailAbonne) {
        this.MailAbonne = MailAbonne;
    }
    
    @Column(name= "DateAdhesion")
    public Timestamp getDateAdhesion() {
        return DateAdhesion;
    }

    public void setDateAdhesion(Timestamp DateAdhesion) {
        this.DateAdhesion = DateAdhesion;
    }
    
    @Column(name= "NiveauAbonne")
    public String getNiveauAbonne() {
        return NiveauAbonne;
    }

    public void setNiveauAbonne(String NiveauAbonne) {
        this.NiveauAbonne = NiveauAbonne;
    }
}


