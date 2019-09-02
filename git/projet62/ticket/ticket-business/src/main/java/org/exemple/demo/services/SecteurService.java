package org.exemple.demo.services;
import java.util.List;
import javax.persistence.*;

import org.exemple.demo.consumer.dao.AbonneDao;
import org.exemple.demo.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.exemple.demo.hibernate.*;
import org.exemple.demo.consumer.dao.SecteurDao;
import org.exemple.demo.entities.Secteur;

public class SecteurService {
	private static SecteurDao SecteurDao;
	
	public SecteurService() {
		SecteurDao = new SecteurDao();
	}

	public void persist(Secteur Secteur) {
		SecteurDao.openCurrentSessionwithTransaction();
		SecteurDao.persist(Secteur);
		SecteurDao.closeCurrentSessionwithTransaction();
	}

	public void update(Secteur Secteur) {
		SecteurDao.openCurrentSessionwithTransaction();
		SecteurDao.update(Secteur);
		SecteurDao.closeCurrentSessionwithTransaction();
	}

	public Secteur findById(String id) {
		SecteurDao.openCurrentSession();
		Secteur Secteur = SecteurDao.findById(id);
		SecteurDao.closeCurrentSession();
		return Secteur;
	}

	public void delete(String id) {
		SecteurDao.openCurrentSessionwithTransaction();
		Secteur Secteur = SecteurDao.findById(id);
		SecteurDao.delete(Secteur);
		SecteurDao.closeCurrentSessionwithTransaction();
	}

	public List<Secteur> findAll() {
		SecteurDao.openCurrentSession();
		List<Secteur> Secteurs = SecteurDao.findAll();
		SecteurDao.closeCurrentSession();
		return Secteurs;
	}

	public void deleteAll() {
		SecteurDao.openCurrentSessionwithTransaction();
		SecteurDao.deleteAll();
		SecteurDao.closeCurrentSessionwithTransaction();
	}

	public SecteurDao SecteurDao() {
		return SecteurDao;
	}
	

}
