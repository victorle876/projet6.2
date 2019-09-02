package org.exemple.demo.services;
import java.util.List;

import org.exemple.demo.consumer.dao.AbonneDao;
import org.exemple.demo.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.exemple.demo.hibernate.*;
import org.exemple.demo.consumer.dao.TopologieDao;
import org.exemple.demo.entities.Topologie;

public class TopologieService {
private static TopologieDao TopologieDao;
	
	public TopologieService() {
		TopologieDao = new TopologieDao();
	}

	public void persist(Topologie Topologie) {
		TopologieDao.openCurrentSessionwithTransaction();
		TopologieDao.persist(Topologie);
		TopologieDao.closeCurrentSessionwithTransaction();
	}

	public void update(Topologie Topologie) {
		TopologieDao.openCurrentSessionwithTransaction();
		TopologieDao.update(Topologie);
		TopologieDao.closeCurrentSessionwithTransaction();
	}

	public Topologie findById(String id) {
		TopologieDao.openCurrentSession();
		Topologie Topologie = TopologieDao.findById(id);
		TopologieDao.closeCurrentSession();
		return Topologie;
	}

	public void delete(String id) {
		TopologieDao.openCurrentSessionwithTransaction();
		Topologie Topologie = TopologieDao.findById(id);
		TopologieDao.delete(Topologie);
		TopologieDao.closeCurrentSessionwithTransaction();
	}

	public List<Topologie> findAll() {
		TopologieDao.openCurrentSession();
		List<Topologie> Topologies = TopologieDao.findAll();
		TopologieDao.closeCurrentSession();
		return Topologies;
	}

	public void deleteAll() {
		TopologieDao.openCurrentSessionwithTransaction();
		TopologieDao.deleteAll();
		TopologieDao.closeCurrentSessionwithTransaction();
	}

	public TopologieDao TopologieDao() {
		return TopologieDao;
	}


}
