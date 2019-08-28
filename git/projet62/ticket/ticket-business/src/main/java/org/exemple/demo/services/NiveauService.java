package org.exemple.demo.services;

import java.util.List;
import javax.persistence.*;

import org.exemple.demo.consumer.dao.NiveauDao;
import org.exemple.demo.dao.*;
import org.exemple.demo.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.exemple.demo.hibernate.*;

public class NiveauService {
	private static NiveauDao NiveauDao;

	public NiveauService() {
    	NiveauDao = new NiveauDao();
    }

	public void persist(Niveau entity) {
		NiveauDao.openCurrentSessionwithTransaction();
		NiveauDao.persist(entity);
		NiveauDao.closeCurrentSessionwithTransaction();
	}

	public void update(Niveau entity) {
		NiveauDao.openCurrentSessionwithTransaction();
		NiveauDao.update(entity);
		NiveauDao.closeCurrentSessionwithTransaction();
	}

	public Niveau findById(String id) {
		NiveauDao.openCurrentSession();
		Niveau Niveau = NiveauDao.findById(id);
		NiveauDao.closeCurrentSession();
		return Niveau;
	}

	public void delete(String id) {
		NiveauDao.openCurrentSessionwithTransaction();
		Niveau Niveau = NiveauDao.findById(id);
		NiveauDao.delete(Niveau);
		NiveauDao.closeCurrentSessionwithTransaction();
	}

	public List<Niveau> findAll() {
		NiveauDao.openCurrentSession();
		List<Niveau> Niveaus = NiveauDao.findAll();
		NiveauDao.closeCurrentSession();
		return Niveaus;
	}

	public void deleteAll() {
		NiveauDao.openCurrentSessionwithTransaction();
		NiveauDao.deleteAll();
		NiveauDao.closeCurrentSessionwithTransaction();
	}

	public NiveauDao NiveauDao() {
		return NiveauDao;
	}

}
