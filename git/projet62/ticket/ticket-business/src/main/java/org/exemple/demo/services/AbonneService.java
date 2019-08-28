package org.exemple.demo.services;

import java.util.List;
import javax.persistence.*;

import org.exemple.demo.consumer.dao.AbonneDao;
import org.exemple.demo.dao.*;
import org.exemple.demo.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.exemple.demo.hibernate.*;

public class AbonneService {
	private static AbonneDao AbonneDao;
	
	public AbonneService() {
		AbonneDao = new AbonneDao();
	}

	public void persist(Abonne abonne) {
		AbonneDao.openCurrentSessionwithTransaction();
		AbonneDao.persist(abonne);
		AbonneDao.closeCurrentSessionwithTransaction();
	}

	public void update(Abonne abonne) {
		AbonneDao.openCurrentSessionwithTransaction();
		AbonneDao.update(abonne);
		AbonneDao.closeCurrentSessionwithTransaction();
	}

	public Abonne findById(String id) {
		AbonneDao.openCurrentSession();
		Abonne abonne = AbonneDao.findById(id);
		AbonneDao.closeCurrentSession();
		return abonne;
	}

	public void delete(String id) {
		AbonneDao.openCurrentSessionwithTransaction();
		Abonne Abonne = AbonneDao.findById(id);
		AbonneDao.delete(Abonne);
		AbonneDao.closeCurrentSessionwithTransaction();
	}

	public List<Abonne> findAll() {
		AbonneDao.openCurrentSession();
		List<Abonne> Abonnes = AbonneDao.findAll();
		AbonneDao.closeCurrentSession();
		return Abonnes;
	}

	public void deleteAll() {
		AbonneDao.openCurrentSessionwithTransaction();
		AbonneDao.deleteAll();
		AbonneDao.closeCurrentSessionwithTransaction();
	}

	public AbonneDao AbonneDao() {
		return AbonneDao;
	}

}
