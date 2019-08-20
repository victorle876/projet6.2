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
	SessionFactory sessionFactory;
	
	public SiteDao(){
		
	}
    public void persist(Site entity) {
        sessionFactory.getCurrentSession().save(entity);
    }
 
    public void update(Site entity) {
    	 sessionFactory.getCurrentSession().update(entity);
    }
 
    public Site findById(String id) {
        Site Site = (Site)  sessionFactory.getCurrentSession().get(Site.class, id);
        return Site; 
    }
 
    public void delete(Site entity) {
    	 sessionFactory.getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Site> findAll() {
        List<Site> Sites = (List<Site>)  sessionFactory.getCurrentSession().createQuery("from Site").list();
        return Sites;
    }
 
    public void deleteAll() {
        List<Site> entityList = findAll();
        for (Site entity : entityList) {
            delete(entity);
        }
    }
}
