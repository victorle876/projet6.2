
package org.exemple.demo.entities;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "NIVEAU")
public class Niveau implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    
    private String LibelleNiveau ;
    
	public Niveau(int id, String LibelleNiveau) {
		this.id = id;
		this.LibelleNiveau = LibelleNiveau;

}

    @Column(name= "niveau_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name= "LibelleNiveau")
    public String getLibelleNiveau() {
        return LibelleNiveau;
    }

    public void setLibelleNiveau(String LibelleNiveau) {
        this.LibelleNiveau = LibelleNiveau;
    }
}
