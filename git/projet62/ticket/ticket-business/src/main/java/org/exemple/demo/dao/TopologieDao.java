package org.exemple.demo.dao;
import org.exemple.demo.daoInterface.*;

import java.util.List;

import org.exemple.demo.entities.Topologie;
import org.exemple.demo.daoInterface.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class TopologieDao implements TopologieDaoInterface<Topologie, String> {
	SessionFactory sessionFactory;
	
	public TopologieDao(){
		
	}
    public void persist(Topologie entity) {
        sessionFactory.getCurrentSession().save(entity);
    }
 
    public void update(Topologie entity) {
    	 sessionFactory.getCurrentSession().update(entity);
    }
 
    public Topologie findById(String id) {
        Topologie Topologie = (Topologie)  sessionFactory.getCurrentSession().get(Topologie.class, id);
        return Topologie; 
    }
 
    public void delete(Topologie entity) {
    	 sessionFactory.getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Topologie> findAll() {
        List<Topologie> Topologies = (List<Topologie>)  sessionFactory.getCurrentSession().createQuery("from Topologie").list();
        return Topologies;
    }
 
    public void deleteAll() {
        List<Topologie> entityList = findAll();
        for (Topologie entity : entityList) {
            delete(entity);
        }
    }
}

