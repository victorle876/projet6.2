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
	private Session currentSession; 
	private Transaction currentTransaction;
	
	public TopologieDao(){
		
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
    public void persist(Topologie topologie) {
        getCurrentSession().save(topologie);
    }
 
    public void update(Topologie topologie) {
    	 getCurrentSession().update(topologie);
    }
 
    public Topologie findById(String id) {
        Topologie Topologie = (Topologie)  getCurrentSession().get(Topologie.class, id);
        return Topologie; 
    }
 
    public void delete(Topologie topologie) {
    	 getCurrentSession().delete(topologie);
    }
 
    @SuppressWarnings("unchecked")
    public List<Topologie> findAll() {
        List<Topologie> Topologies = (List<Topologie>)  getCurrentSession().createQuery("from Topologie").list();
        return Topologies;
    }
 
    public void deleteAll() {
        List<Topologie> topologieList = findAll();
        for (Topologie topologie : topologieList) {
            delete(topologie);
        }
    }
}

