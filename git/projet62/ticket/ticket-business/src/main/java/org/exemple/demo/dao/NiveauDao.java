package org.exemple.demo.dao;

import java.util.List;

import org.exemple.demo.entities.Niveau;
import org.exemple.demo.daoInterface.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class NiveauDao implements NiveauDaoInterface<Niveau, String> {
	SessionFactory sessionFactory;
	private Session currentSession; 
	private Transaction currentTransaction;
	
	public NiveauDao(){
		
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
    
    public void persist(Niveau niveau) {
         getCurrentSession().save(niveau);
    }
 
    public void update(Niveau niveau) {
    	  getCurrentSession().update(niveau);
    }
 
    public Niveau findById(String id) {
        Niveau Niveau = (Niveau)   getCurrentSession().get(Niveau.class, id);
        return Niveau; 
    }
 
    public void delete(Niveau niveau) {
    	  getCurrentSession().delete(niveau);
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
