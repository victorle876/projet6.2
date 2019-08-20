package org.exemple.demo.dao;

import java.util.List;

import org.exemple.demo.daoInterface.SecteurDaoInterface;
import org.exemple.demo.entities.Secteur;
import org.exemple.demo.daoInterface.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SecteurDao implements SecteurDaoInterface<Secteur, String> {
	SessionFactory sessionFactory;
	
	public SecteurDao(){
		
	}
    public void persist(Secteur entity) {
        sessionFactory.getCurrentSession().save(entity);
    }
 
    public void update(Secteur entity) {
    	 sessionFactory.getCurrentSession().update(entity);
    }
 
    public Secteur findById(String id) {
        Secteur Secteur = (Secteur)  sessionFactory.getCurrentSession().get(Secteur.class, id);
        return Secteur; 
    }
 
    public void delete(Secteur entity) {
    	 sessionFactory.getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Secteur> findAll() {
        List<Secteur> Secteurs = (List<Secteur>)  sessionFactory.getCurrentSession().createQuery("from Secteur").list();
        return Secteurs;
    }
 
    public void deleteAll() {
        List<Secteur> entityList = findAll();
        for (Secteur entity : entityList) {
            delete(entity);
        }
    }
    
}
