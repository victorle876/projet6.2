package org.exemple.demo.daoInterface;

import java.io.Serializable;
import java.util.List;
 
public interface SecteurDaoInterface<T, Id extends Serializable> {
 
    public void persist(T secteur);
     
    public void update(T secteur);
     
    public T findById(Id id);
     
    public void delete(T secteur);
     
    public List<T> findAll();
     
    public void deleteAll();
     
}

