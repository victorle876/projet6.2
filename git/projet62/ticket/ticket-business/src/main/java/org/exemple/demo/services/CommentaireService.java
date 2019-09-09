package org.exemple.demo.services;
import java.util.List;
import javax.persistence.*;

import org.exemple.demo.consumer.dao.CommentaireDao;
import org.exemple.demo.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.exemple.demo.hibernate.*;

public class CommentaireService {
	private static CommentaireDao CommentaireDao;
	
	private Site site;
	private Abonne abonne;
	
public CommentaireService() {
	
}

	public void persist(Commentaire commentaire) {
		CommentaireDao.openCurrentSessionwithTransaction();
		CommentaireDao.persist(commentaire);
		CommentaireDao.closeCurrentSessionwithTransaction();
	}

	public void update(Commentaire entity) {
		CommentaireDao.openCurrentSessionwithTransaction();
		CommentaireDao.update(entity);
		CommentaireDao.closeCurrentSessionwithTransaction();
	}

	public Commentaire findById(String id) {
		CommentaireDao.openCurrentSession();
		Commentaire Commentaire = CommentaireDao.findById(id);
		CommentaireDao.closeCurrentSession();
		return Commentaire;
	}

	public void delete(String id) {
		CommentaireDao.openCurrentSessionwithTransaction();
		Commentaire Commentaire = CommentaireDao.findById(id);
		CommentaireDao.delete(Commentaire);
		CommentaireDao.closeCurrentSessionwithTransaction();
	}

	public List<Commentaire> findAll() {
		CommentaireDao.openCurrentSession();
		List<Commentaire> Commentaires = CommentaireDao.findAll();
		CommentaireDao.closeCurrentSession();
		return Commentaires;
	}
	
	public List<Commentaire> Find_By_Site_Abonne() {
		CommentaireDao.openCurrentSession();
		Commentaire Commentaires = CommentaireDao.Find_By_Site_Abonne(site, abonne);
		CommentaireDao.closeCurrentSession();
		return Commentaires;
	}

	public void deleteAll() {
		CommentaireDao.openCurrentSessionwithTransaction();
		CommentaireDao.deleteAll();
		CommentaireDao.closeCurrentSessionwithTransaction();
	}

	public CommentaireDao CommentaireDao() {
		return CommentaireDao;
	}

}

