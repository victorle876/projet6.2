package org.exemple.demo.consumer.dao;

import org.exemple.demo.entities.* ;
import org.exemple.demo.consumer.daoInterface.AbonneDaoInterface;
import org.exemple.demo.consumer.daoInterface.CommentaireDaoInterface;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public abstract class CommentaireDao implements CommentaireDaoInterface {
	private AbstractDao AbstractDao ;

	public CommentaireDao() {

	}

	public void persist(Commentaire commentaire) {
		AbstractDao.getCurrentSession().save(commentaire);
	}

	public void update(Commentaire commentaire) {
		AbstractDao.getCurrentSession().update(commentaire);
	}

	public Commentaire findById(String id) {
		Commentaire Commentaire = (Commentaire) AbstractDao.getCurrentSession().get(Commentaire.class, id);
		return Commentaire;
	}
	


	public void delete(Commentaire commentaire) {
		AbstractDao.getCurrentSession().delete(commentaire);
	}

	@SuppressWarnings("unchecked")
	public List<Commentaire> findAll() {
		List<Commentaire> Commentaires = (List<Commentaire>) AbstractDao.getCurrentSession()
				.createQuery("from Commentaire").list();
		return Commentaires;
	}
	
	@SuppressWarnings("unchecked")
	public Commentaire Find_By_Site_Abonne(Site site, Abonne abonne) {
		Commentaire Commentaire = (Commentaire) AbstractDao.getCurrentSession().createQuery("Commentaire.Find_By_Site_User").list();;
		return Commentaire;
	}

	public void deleteAll() {
		List<Commentaire> commentaireList = findAll();
		for (Commentaire commentaire : commentaireList) {
			delete(commentaire);
		}
	}

}
