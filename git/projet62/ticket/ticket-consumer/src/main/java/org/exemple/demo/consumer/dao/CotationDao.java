package org.exemple.demo.consumer.dao;

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
    public Session getCurrentSession() {
        return currentSession;
    }
    
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
    
    public void closeCurrentSession() {
        currentSession.close();
    }
    
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    
    public void persist(Cotation cotation) {
        getCurrentSession().save(cotation);
    }
 
    public void update(Cotation cotation) {
    	 getCurrentSession().update(cotation);
    }
 
    public Cotation findById(String id) {
        Cotation Cotation = (Cotation)  getCurrentSession().get(Cotation.class, id);
        return Cotation; 
    }
 
    public void delete(Cotation cotation) {
    	 getCurrentSession().delete(cotation);
    }
 
    @SuppressWarnings("unchecked")
    public List<Cotation> findAll() {
        List<Cotation> Cotations = (List<Cotation>)  getCurrentSession().createQuery("from Cotation").list();
        return Cotations;
    }
 
    public void deleteAll() {
        List<Cotation> cotationList = findAll();
        for (Cotation cotation : cotationList) {
            delete(cotation);
        }
    }
}
