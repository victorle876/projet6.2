package org.exemple.demo.dao;
import org.exemple.demo.hibernate.util.*;

import org.exemple.demo.entities.*;
import org.exemple.demo.daoInterface.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

 /* public interface AbonneDao { */
public class AbonneDao implements AbonneDaoInterface<Abonne, String> {
	SessionFactory sessionFactory;
	
	public AbonneDao(){
		
	}
    public void persist(Abonne entity) {
    	
    	sessionFactory.getCurrentSession().save(entity);
    }
 
    public void update(Abonne entity) {
    	sessionFactory.getCurrentSession().update(entity);
    }
 
    public Abonne findById(String id) {
        Abonne Abonne = (Abonne)  sessionFactory.getCurrentSession().get(Abonne.class, id);
        return Abonne; 
    }
 
    public void delete(Abonne entity) {
    	sessionFactory.getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Abonne> findAll() {
        List<Abonne> Abonnes = (List<Abonne>)  sessionFactory.getCurrentSession().createQuery("from Abonne").list();
        return Abonnes;
    }
 
    public void deleteAll() {
        List<Abonne> entityList = findAll();
        for (Abonne entity : entityList) {
            delete(entity);
        }
    }
	

}