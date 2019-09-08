
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

    private String Libelle_Niveau ;

    public String getLibelle_Niveau() {
        return Libelle_Niveau;
    }

    public void setLibelle_Niveau(String Libelle_Niveau) {
        this.Libelle_Niveau = Libelle_Niveau;
    }
}
