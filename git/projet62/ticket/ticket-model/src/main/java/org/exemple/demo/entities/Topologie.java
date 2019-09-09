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
@Table(name = "TOPOLOGIE")
@NamedQueries({
    @NamedQuery(name = Topologie.Find_By_Topologie_Site, query = "SELECT topologie, site FROM Topologie t WHERE t.site = :site "),
})
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
    
    @OneToOne
    @JoinColumn(name = "Site_id")
    private Site site;

    private String Libelle_Topologie ;

    private Timestamp Date_Maj ;
    
    private Timestamp Date_Parution ;
    public String getLibelle_topologie() {
        return Libelle_Topologie;
    }

    public void setLibelle_Topologie(String libelle_topologie) {
        this.Libelle_Topologie = libelle_topologie;
    }

    public Timestamp getDate_Maj() {
        return Date_Maj;
    }

    public void setDate_Maj(Timestamp date_maj) {
        this.Date_Maj = date_maj;
    }
    
    public Timestamp getDate_Parution() {
        return Date_Parution;
    }

    public void setDate_Parution(Timestamp date_parution) {
        this.Date_Parution = date_parution;
    }


}
