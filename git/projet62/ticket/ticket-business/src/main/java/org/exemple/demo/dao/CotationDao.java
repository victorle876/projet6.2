package org.exemple.demo.dao;

import java.util.List;

import org.exemple.demo.entities.Cotation;
import org.exemple.demo.entities.*;
import org.exemple.demo.daoInterface.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CotationDao implements CotationDaoInterface<Cotation, String> {

	SessionFactory sessionFactory;
	private Session currentSession; 
	private Transaction currentTransaction;
	
	public CotationDao(){
		
	}
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
    
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    public void persist(Cotation entity) {
        sessionFactory.getCurrentSession().save(entity);
    }
 
    public void update(Cotation entity) {
    	 sessionFactory.getCurrentSession().update(entity);
    }
 
    public Cotation findById(String id) {
        Cotation Cotation = (Cotation)  sessionFactory.getCurrentSession().get(Cotation.class, id);
        return Cotation; 
    }
 
    public void delete(Cotation entity) {
    	 sessionFactory.getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Cotation> findAll() {
        List<Cotation> Cotations = (List<Cotation>)  sessionFactory.getCurrentSession().createQuery("from Cotation").list();
        return Cotations;
    }
 
    public void deleteAll() {
        List<Cotation> entityList = findAll();
        for (Cotation entity : entityList) {
            delete(entity);
        }
    }
}
