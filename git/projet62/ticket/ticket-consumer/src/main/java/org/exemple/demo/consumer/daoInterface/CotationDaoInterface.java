package org.exemple.demo.consumer.daoInterface;

import java.io.Serializable;
import java.util.List;
 
public interface CotationDaoInterface<T, Id extends Serializable> {
 
    public void persist(T cotation);
     
    public void update(T cotation);
     
    public T findById(Id id);
     
    public void delete(T cotation);
     
    public List<T> findAll();
     
    public void deleteAll();
     
}
