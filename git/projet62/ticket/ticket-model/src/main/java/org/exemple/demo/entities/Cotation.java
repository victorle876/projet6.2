package org.exemple.demo.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "COTATION")
public class Cotation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String LibelleCotation ;
    
    private String NumDifficulte;

    @Column(name = "cotation_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getLibelleCotation() {
        return LibelleCotation;
    }

    public void setCotation(String LibelleCotation) {
        this.LibelleCotation = LibelleCotation;
    }

    @JoinColumn(name = "NumDifficulte")
    public String getNumDifficulte() {
        return NumDifficulte;
    }

    public void setNumDifficulte(String NumDifficulte) {
        this.NumDifficulte = NumDifficulte;
    }
}
