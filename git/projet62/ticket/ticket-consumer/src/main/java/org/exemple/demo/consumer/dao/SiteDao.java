package org.exemple.demo.consumer.dao;

import java.util.List;

import org.exemple.demo.entities.Site;
import org.exemple.demo.consumer.daoInterface.SiteDaoInterface;
import org.exemple.demo.entities.Niveau;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SiteDao implements AbstractDao {
	private AbstractDao AbstractDao; 
	
	public SiteDao(){
		
	}
	
    public void persist(Site site) {
    	AbstractDao.getCurrentSession().save(site);
    }
 
    public void update(Site site) {
    	AbstractDao.getCurrentSession().update(site);
    }
 
    public Site findById(String id) {
        Site Site = (Site)  AbstractDao.getCurrentSession().get(Site.class, id);
        return Site; 
    }
 
    public void delete(Site site) {
    	AbstractDao.getCurrentSession().delete(site);
    }
 
    @SuppressWarnings("unchecked")
    public List<Site> findAll() {
        List<Site> Sites = (List<Site>) AbstractDao.getCurrentSession().createQuery("from Site").list();
        return Sites;
    }
 
    public void deleteAll() {
        List<Site> siteList = findAll();
        for (Site site : siteList) {
            delete(site);
        }
    }
}
