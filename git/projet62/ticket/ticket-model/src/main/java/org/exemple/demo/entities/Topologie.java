package org.exemple.demo.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TOPOLOGIE")
public class Topologie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String libelle_topologie ;
    private String num_site_escalade ;

    private String date_maj ;

    public String getLibelle_topologie() {
        return libelle_topologie;
    }

    public void setLibelle_topologie(String libelle_topologie) {
        this.libelle_topologie = libelle_topologie;
    }

    public String getNum_site_escalade() {
        return num_site_escalade;
    }

    public void setNum_site_escalade(String num_site_escalade) {
        this.num_site_escalade = num_site_escalade;
    }

    public String getDate_maj() {
        return date_maj;
    }

    public void setDate_maj(String date_maj) {
        this.date_maj = date_maj;
    }


}
