package org.exemple.demo.consumer.daoInterface;
import java.io.Serializable;
import java.util.List;
 
public interface AbonneDaoInterface<T, Id extends Serializable> {
 
    public void persist(T abonne);
     
    public void update(T abonne);
     
    public T findById(Id id);
     
    public void delete(T abonne);
     
    public List<T> findAll();
     
    public void deleteAll();
     
}
