package org.exemple.demo.dao;

import org.exemple.demo.daoInterface.*;

import java.util.List;

import org.exemple.demo.entities.Commentaire;
import org.hibernate.SessionFactory;
import org.exemple.demo.entities.Commentaire;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CommentaireDao implements CommentaireDaoInterface<Commentaire, String> {

	SessionFactory sessionFactory;

public CommentaireDao(){
		
	}

	public void persist(Commentaire entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public void update(Commentaire entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	public Commentaire findById(String id) {
		Commentaire Commentaire = (Commentaire) sessionFactory.getCurrentSession().get(Commentaire.class, id);
		return Commentaire;
	}

	public void delete(Commentaire entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Commentaire> findAll() {
		List<Commentaire> Commentaires = (List<Commentaire>) sessionFactory.getCurrentSession()
				.createQuery("from Commentaire").list();
		return Commentaires;
	}

	public void deleteAll() {
		List<Commentaire> entityList = findAll();
		for (Commentaire entity : entityList) {
			delete(entity);
		}
	}

}
