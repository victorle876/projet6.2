package org.exemple.demo.daoInterface;

import java.io.Serializable;
import java.util.List;
 
public interface CommentaireDaoInterface<T, Id extends Serializable> {
 
    public void persist(T commentaire);
     
    public void update(T commentaire);
     
    public T findById(Id id);
     
    public void delete(T commentaire);
     
    public List<T> findAll();
     
    public void deleteAll();
     
}

