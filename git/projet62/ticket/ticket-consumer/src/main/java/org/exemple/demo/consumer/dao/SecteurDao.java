package org.exemple.demo.consumer.dao;

import java.util.List;

import org.exemple.demo.entities.Secteur;
import org.exemple.demo.consumer.daoInterface.SecteurDaoInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SecteurDao implements SecteurDaoInterface<Secteur, String> {
	private Session currentSession; 
	private Transaction currentTransaction;
	
	public SecteurDao(){
		
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
    public void persist(Secteur secteur) {
        getCurrentSession().save(secteur);
    }
 
    public void update(Secteur secteur) {
    	 getCurrentSession().update(secteur);
    }
 
    public Secteur findById(String id) {
        Secteur Secteur = (Secteur)  getCurrentSession().get(Secteur.class, id);
        return Secteur; 
    }
 
    public void delete(Secteur secteur) {
    	 getCurrentSession().delete(secteur);
    }
 
    @SuppressWarnings("unchecked")
    public List<Secteur> findAll() {
        List<Secteur> Secteurs = (List<Secteur>)  getCurrentSession().createQuery("from Secteur").list();
        return Secteurs;
    }
 
    public void deleteAll() {
        List<Secteur> secteurList = findAll();
        for (Secteur secteur : secteurList) {
            delete(secteur);
        }
    }
    
}
