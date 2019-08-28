package org.exemple.demo.consumer.daoInterface;
import java.io.Serializable;
import java.util.List;
 
public interface TopologieDaoInterface<T, Id extends Serializable> {
 
    public void persist(T topologie);
     
    public void update(T topologie);
     
    public T findById(Id id);
     
    public void delete(T topologie);
     
    public List<T> findAll();
     
    public void deleteAll();
     
}
