package org.exemple.demo.dao;
import org.exemple.demo.daoInterface.*;

import java.util.List;

import org.exemple.demo.entities.Site;
import org.exemple.demo.entities.Niveau;
import org.exemple.demo.daoInterface.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SiteDao implements SiteDaoInterface<Site, String> {
	private Session currentSession; 
	private Transaction currentTransaction;
	
	public SiteDao(){
		
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
    public void persist(Site site) {
        getCurrentSession().save(site);
    }
 
    public void update(Site site) {
    	 getCurrentSession().update(site);
    }
 
    public Site findById(String id) {
        Site Site = (Site)  getCurrentSession().get(Site.class, id);
        return Site; 
    }
 
    public void delete(Site site) {
    	 getCurrentSession().delete(site);
    }
 
    @SuppressWarnings("unchecked")
    public List<Site> findAll() {
        List<Site> Sites = (List<Site>)  getCurrentSession().createQuery("from Site").list();
        return Sites;
    }
 
    public void deleteAll() {
        List<Site> siteList = findAll();
        for (Site site : siteList) {
            delete(site);
        }
    }
}
