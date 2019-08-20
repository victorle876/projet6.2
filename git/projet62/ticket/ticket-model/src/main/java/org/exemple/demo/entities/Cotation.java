package org.exemple.demo.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "COTATION")
public class Cotation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String Libelle_cotation ;

    public String getLibelle_cotation() {
        return Libelle_cotation;
    }

    public void setCotation(String cotation) {
        this.Libelle_cotation = Libelle_cotation;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String num_difficulte;

    public String getNum_difficulte() {
        return num_difficulte;
    }

    public void setNum_difficulte(String num_difficulte) {
        this.num_difficulte = num_difficulte;
    }
}
