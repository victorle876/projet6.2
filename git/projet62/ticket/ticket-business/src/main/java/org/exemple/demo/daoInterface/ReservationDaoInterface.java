package org.exemple.demo.daoInterface;

import java.io.Serializable;
import java.util.List;
 
public interface ReservationDaoInterface<T, Id extends Serializable> {
 
    public void persist(T reservation);
     
    public void update(T reservation);
     
    public T findById(Id id);
     
    public void delete(T reservation);
     
    public List<T> findAll();
     
    public void deleteAll();
     
}
