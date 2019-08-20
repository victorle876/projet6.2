
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
@Table(name = "NIVEAU")
public class Niveau implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String libelle_niveau ;

    public String getLibelle_niveau() {
        return libelle_niveau;
    }

    public void setLibelle_niveau(String libelle_niveau) {
        this.libelle_niveau = libelle_niveau;
    }
}
