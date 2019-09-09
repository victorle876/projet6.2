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

    private String Libelle_Cotation ;

    public String getLibelle_Cotation() {
        return Libelle_Cotation;
    }

    public void setCotation(String cotation) {
        this.Libelle_Cotation = Libelle_Cotation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String Num_Difficulte;

    public String getNum_difficulte() {
        return Num_Difficulte;
    }

    public void setNum_Difficulte(String num_difficulte) {
        this.Num_Difficulte = num_difficulte;
    }
}
