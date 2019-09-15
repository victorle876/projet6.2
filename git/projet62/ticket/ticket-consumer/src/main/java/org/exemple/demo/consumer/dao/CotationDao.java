package org.exemple.demo.consumer.dao;

import java.util.List;

import org.exemple.demo.entities.Cotation;
import org.exemple.demo.entities.*;
import org.exemple.demo.consumer.daoInterface.CotationDaoInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CotationDao implements AbstractDao {

	private AbstractDao AbstractDao;
	
	public CotationDao(){
		
	}
    
    public void persist(Cotation cotation) {
    	AbstractDao.getCurrentSession().save(cotation);
    }
 
    public void update(Cotation cotation) {
    	AbstractDao.getCurrentSession().update(cotation);
    }
 
    public Cotation findById(String id) {
        Cotation Cotation = (Cotation) AbstractDao.getCurrentSession().get(Cotation.class, id);
        return Cotation; 
    }
 
    public void delete(Cotation cotation) {
    	AbstractDao.getCurrentSession().delete(cotation);
    }
 
    @SuppressWarnings("unchecked")
    public List<Cotation> findAll() {
        List<Cotation> Cotations = (List<Cotation>) AbstractDao.getCurrentSession().createQuery("from Cotation").list();
        return Cotations;
    }
 
    public void deleteAll() {
        List<Cotation> cotationList = findAll();
        for (Cotation cotation : cotationList) {
            delete(cotation);
        }
    }
}
