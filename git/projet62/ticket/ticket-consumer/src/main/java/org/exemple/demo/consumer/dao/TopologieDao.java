package org.exemple.demo.consumer.dao;

import java.util.List;

import org.exemple.demo.consumer.daoInterface.TopologieDaoInterface;
import org.exemple.demo.entities.Topologie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class TopologieDao implements AbstractDao {
	private AbstractDao AbstractDao ; 
	
	public TopologieDao(){
		
	}

    public void persist(Topologie topologie) {
    	AbstractDao.getCurrentSession().save(topologie);
    }
 
    public void update(Topologie topologie) {
    	AbstractDao.getCurrentSession().update(topologie);
    }
 
    public Topologie findById(String id) {
        Topologie Topologie = (Topologie)AbstractDao.getCurrentSession().get(Topologie.class, id);
        return Topologie; 
    }
 
    public void delete(Topologie topologie) {
    	AbstractDao.getCurrentSession().delete(topologie);
    }
 
    @SuppressWarnings("unchecked")
    public List<Topologie> findAll() {
        List<Topologie> Topologies = (List<Topologie>) AbstractDao.getCurrentSession().createQuery("from Topologie").list();
        return Topologies;
    }
 
    public void deleteAll() {
        List<Topologie> topologieList = findAll();
        for (Topologie topologie : topologieList) {
            delete(topologie);
        }
    }
}

