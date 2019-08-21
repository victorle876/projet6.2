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
    //private	SessionFactory sessionFactory;
	private Session currentSession; 
	private Transaction currentTransaction;
//	private Abonne Abonne;
	
	public AbonneDao(){
		
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
    public void persist(Abonne abonne) {
    	
    	getCurrentSession().save(abonne);
    }
 
    public void update(Abonne abonne) {
    	getCurrentSession().update(abonne);
    }
 
    public Abonne findById(String id) {
        Abonne Abonne = (Abonne) getCurrentSession().get(Abonne.class, id);
        return Abonne; 
    }
 
    public void delete(Abonne abonne) {
    	getCurrentSession().delete(abonne);
    }
 
    @SuppressWarnings("unchecked")
    public List<Abonne> findAll() {
        List<Abonne> Abonnes = (List<Abonne>) getCurrentSession().createQuery("from Abonne").list();
        return Abonnes;
    }
 
    public void deleteAll() {
        List<Abonne> abonneList = findAll();
        for (Abonne abonne : abonneList) {
            delete(abonne);
        }
    }
	

}