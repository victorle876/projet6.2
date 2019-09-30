package org.exemple.demo.entities;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "TOPOLOGIE")
//@NamedQueries({
//    @NamedQuery(name = Topologie.Find_By_Topologie_Site, query = "SELECT topologie, site FROM Topologie t WHERE t.site = :site "),
//})
public class Topologie implements Serializable{
	
	public static final String Find_By_Topologie_Site = "Topologie.FindBySite";
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name= "Topologie_Id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  
    @OneToMany(mappedBy = "Site_Id")
    private Site site;

    private String LibelleTopologie ;

    private Timestamp DateMaj ;
    
    private Timestamp DateParution ;
    
	public Topologie(int id, String LibelleTopologie, Site site, Timestamp DateMaj,
			Timestamp DateParution) {
		this.id = id;
		this.LibelleTopologie = LibelleTopologie;
		this.site = site;
		this.DateMaj = DateMaj;
		this.DateParution = DateParution;
}
    public String getLibelleTopologie() {
        return LibelleTopologie;
    }

    public void setLibelleTopologie(String LibelleTopologie) {
        this.LibelleTopologie = LibelleTopologie;
    }

    public Timestamp getDateMaj() {
        return DateMaj;
    }

    public void setDateMaj(Timestamp DateMaj) {
        this.DateMaj = DateMaj;
    }
    
    public Timestamp getDateParution() {
        return DateParution;
    }

    public void setDateParution(Timestamp DateParution) {
        this.DateParution = DateParution;
    }


}
