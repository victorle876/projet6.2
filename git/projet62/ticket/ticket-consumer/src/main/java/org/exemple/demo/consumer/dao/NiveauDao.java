package org.exemple.demo.consumer.dao;

import java.util.List;

import org.exemple.demo.entities.Niveau;
import org.exemple.demo.consumer.daoInterface.NiveauDaoInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class NiveauDao implements AbstractDao {
	private AbstractDao AbstractDao;
	
	public NiveauDao(){
		
	}
 
    public void persist(Niveau niveau) {
    	AbstractDao.getCurrentSession().save(niveau);
    }
 
    public void update(Niveau niveau) {
    	AbstractDao.getCurrentSession().update(niveau);
    }
 
    public Niveau findById(String id) {
        Niveau Niveau = (Niveau) AbstractDao.getCurrentSession().get(Niveau.class, id);
        return Niveau; 
    }
 
    public void delete(Niveau niveau) {
    	AbstractDao.getCurrentSession().delete(niveau);
    }
 
    @SuppressWarnings("unchecked")
    public List<Niveau> findAll() {
        List<Niveau> Niveaux = (List<Niveau>)getCurrentSession().createQuery("from Niveau").list();
        return Niveaux;
    }
 
    public void deleteAll() {
        List<Niveau> niveauList = findAll();
        for (Niveau niveau : niveauList) {
            delete(niveau);
        }
    }
}
