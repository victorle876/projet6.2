package org.exemple.demo.consumer.daoInterface;
import java.io.Serializable;
import java.util.List;
 
public interface SiteDaoInterface<T, Id extends Serializable> {
 
    public void persist(T site);
     
    public void update(T site);
     
    public T findById(Id id);
     
    public void delete(T site);
     
    public List<T> findAll();
     
    public void deleteAll();
     
}
