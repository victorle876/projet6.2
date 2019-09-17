package org.exemple.demo.consumer.dao;
//créer un sous package impl :classes  xwxxDAo
//import org.exemple.demo.hibernate.util.*;
import javax.persistence.*;
import org.exemple.demo.consumer.daoInterface.AbonneDaoInterface;
import org.exemple.demo.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public abstract class AbonneDao implements AbonneDaoInterface {
	private AbstractDao AbstractDao ;
	
	public AbonneDao(){
		
	}
    public void persist(Abonne abonne) {
    	
    	AbstractDao.getCurrentSession().save(abonne);
    }
 
    public void update(Abonne abonne) {
    	AbstractDao.getCurrentSession().update(abonne);
    }
 
    public Abonne findById(String id) {
        Abonne Abonne = (Abonne) AbstractDao.getCurrentSession().get(Abonne.class, id);
        return Abonne; 
    }
 
    public void delete(Abonne abonne) {
    	AbstractDao.getCurrentSession().delete(abonne);
    }
 
    @SuppressWarnings("unchecked")
    public List<Abonne> findAll() {
        List<Abonne> Abonnes = (List<Abonne>) AbstractDao.getCurrentSession().createQuery("from Abonne").list();
        return Abonnes;
    }
 
    public void deleteAll() {
        List<Abonne> abonneList = findAll();
        for (Abonne abonne : abonneList) {
            delete(abonne);
        }
    }
	

}