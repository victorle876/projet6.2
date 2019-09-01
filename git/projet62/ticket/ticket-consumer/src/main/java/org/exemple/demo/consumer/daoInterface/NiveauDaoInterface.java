package org.exemple.demo.consumer.daoInterface;
import org.exemple.demo.consumer.dao.*;

import java.io.Serializable;
import java.util.List;
 
public interface NiveauDaoInterface<T, Id extends Serializable> {
 
    public void persist(T niveau);
     
    public void update(T niveau);
     
    public T findById(Id id);
     
    public void delete(T niveau);
     
    public List<T> findAll();
     
    public void deleteAll();
     
}
