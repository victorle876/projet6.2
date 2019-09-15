package org.exemple.demo.consumer.dao;

import java.util.List;

import org.exemple.demo.entities.Secteur;
import org.exemple.demo.consumer.daoInterface.SecteurDaoInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SecteurDao implements AbstractDAo {
	private AbstractDao AbstractDao; 

	
	public SecteurDao(){
		
	}
	
    public void persist(Secteur secteur) {
    	AbstractDao.getCurrentSession().save(secteur);
    }
 
    public void update(Secteur secteur) {
    	AbstractDao.getCurrentSession().update(secteur);
    }
 
    public Secteur findById(String id) {
        Secteur Secteur = (Secteur) AbstractDao.getCurrentSession().get(Secteur.class, id);
        return Secteur; 
    }
 
    public void delete(Secteur secteur) {
    	AbstractDao.getCurrentSession().delete(secteur);
    }
 
    @SuppressWarnings("unchecked")
    public List<Secteur> findAll() {
        List<Secteur> Secteurs = (List<Secteur>) AbstractDao.getCurrentSession().createQuery("from Secteur").list();
        return Secteurs;
    }
 
    public void deleteAll() {
        List<Secteur> secteurList = findAll();
        for (Secteur secteur : secteurList) {
            delete(secteur);
        }
    }
    
}
